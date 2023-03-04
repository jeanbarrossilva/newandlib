package com.jeanbarrossilva.newandlib

import com.jeanbarrossilva.newandlib.prompter.Prompter
import com.jeanbarrossilva.newandlib.prompter.hyphenatedProjectName
import com.jeanbarrossilva.newandlib.utils.GradleWrapperPropertiesHeaderDateTimeFormatter
import com.jeanbarrossilva.newandlib.writer.FileWriter
import com.jeanbarrossilva.newandlib.writer.at
import java.nio.file.Paths
import java.time.ZonedDateTime
import kotlin.io.path.createDirectories

internal object Generator {
    context(Prompter)
    fun generate() {
        at(get(Prompts.PROJECT_PATH)!!) {
            writeBuildSrcFiles()
            writeGradleFiles()
            writeAppFiles()
            writeLibraryFiles()
            writeRootFiles()
        }
    }

    context(Prompter)
    private fun FileWriter.writeBuildSrcFiles() {
        writeTo("buildSrc/src/main/java/utils/Properties.extensions", """
            import java.io.File
            import java.io.InputStreamReader
            import java.util.Properties
            
            /**
             * Creates [Properties] according to the `local.properties` file.
             *
             * @param root Directory in which the `local.properties` file is.
             **/
            fun localProperties(root: File): Properties {
                val file = File(root, "local.properties")
                return Properties().apply { tryToLoad(file) }
            }
            
            /**
             * Loads the given [file] into these [Properties].
             *
             * @param file [File] to be loaded.
             **/
            private fun Properties.load(file: File) {
                file.inputStream().reader().use {
                    load(it)
                }
            }
            
            /**
             * Loads the given [file] into these [Properties] if it's a normal file.
             *
             * @param file [File] to be loaded.
             **/
            private fun Properties.tryToLoad(file: File) {
                if (file.isFile) {
                    load(file)
                }
            }
        """)
        writeTo("buildSrc/src/main/java/utils/RepositoryHandler.extensions.kt", """
            import java.net.URI
            import org.gradle.api.Project
            import org.gradle.api.artifacts.dsl.RepositoryHandler
            import org.gradle.api.artifacts.repositories.MavenArtifactRepository
            
            /**
             * Adds the repository in which the
             * [Aurelius design system](https://github.com/jeanbarrossilva/aurelius-android) is located.
             *
             * @param project [Project] to which the repository is being added.
             **/
            fun RepositoryHandler.aurelius(project: Project): MavenArtifactRepository {
                return maven {
                    url = URI.create("https://maven.pkg.github.com/jeanbarrossilva/aurelius-android")
            
                    credentials {
                        with(localProperties(project.rootDir)) {
                            username = getProperty("github.username") ?: System.getenv("GITHUB_USERNAME")
                            password = getProperty("github.token") ?: System.getenv("GITHUB_TOKEN")
                        }
                    }
                }
            }
        """)
        writeTo("buildSrc/src/main/java/Metadata.kt", """
            object Metadata {
                const val GROUP = "${get(Prompts.GROUP_ID)}"
                const val ARTIFACT = "$hyphenatedProjectName"
                const val NAMESPACE = GROUP

                fun namespace(suffix: String): String {
                    return "${'$'}NAMESPACE.${'$'}suffix"
                }
            }
        """)
        writeTo("buildSrc/src/main/java/Plugins.kt", """
            object Plugins {
                const val GRADLE = "com.android.tools.build:gradle:${'$'}{Versions.GRADLE}"
                const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${'$'}{Versions.KOTLIN}"
            }
        """)
        writeTo("buildSrc/src/main/java/Variants.kt", """
            object Variants {
                const val RELEASE = "release"
            }
        """)
        writeTo("buildSrc/src/main/java/Versions.kt", """
            object Versions {
                const val AURELIUS = "1.2.1"
                const val GRADLE = "7.4.1"
                const val KOTLIN = "1.8.10"
                const val TEST_RUNNER = "1.5.2"

                object ${get(Prompts.PROJECT_NAME)} {
                    const val CODE = 0
                    const val NAME = "1.0.0"
                    const val SDK_COMPILE = 33
                    const val SDK_MIN = 21
                    const val SDK_TARGET = SDK_COMPILE
                }
            }
        """)
        writeTo("buildSrc/build.gradle.kts", """
            plugins {
                `kotlin-dsl`
            }
            
            repositories {
                mavenCentral()
            }
        """)
    }

    context(Prompter)
    private fun FileWriter.writeGradleFiles() {
        writeTo("gradle/wrapper/gradle-wrapper.properties", """
            #${ZonedDateTime.now().format(GradleWrapperPropertiesHeaderDateTimeFormatter())}
            distributionBase=GRADLE_USER_HOME
            distributionUrl=https\://services.gradle.org/distributions/gradle-7.5-bin.zip
            distributionPath=wrapper/dists
            zipStorePath=wrapper/dists
            zipStoreBase=GRADLE_USER_HOME
        """)
    }

    context(Prompter)
    private fun FileWriter.writeAppFiles() {
        writeManifestAt("app/src/main")
        writeTo("app/.gitignore", ".build")
        writeTo("app/build.gradle.kts", """
            plugins {
                id("com.android.application")
                id("kotlin-android")
            }
            
            @Suppress("UnstableApiUsage")
            android {
                namespace = Metadata.namespace("app")
                compileSdk = Versions.${get(Prompts.PROJECT_NAME)}.SDK_COMPILE
            
                defaultConfig {
                    applicationId = Metadata.GROUP
                    minSdk = Versions.${get(Prompts.PROJECT_NAME)}.SDK_MIN
                    targetSdk = Versions.${get(Prompts.PROJECT_NAME)}.SDK_TARGET
                    versionCode = Versions.${get(Prompts.PROJECT_NAME)}.CODE
                    versionName = Versions.${get(Prompts.PROJECT_NAME)}.NAME
                    testInstrumentationRunner = Libraries.TEST_RUNNER
                }
            
                buildTypes {
                    getByName(Variants.RELEASE) {
                        isMinifyEnabled = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            
                compileOptions {
                    sourceCompatibility = Versions.java
                    targetCompatibility = Versions.java
                }
            
                kotlinOptions {
                    jvmTarget = Versions.java.toString()
                }
            }
        """)
        writeTo("app/proguard-rules.pro", "")
    }

    context(Prompter)
    private fun FileWriter.writeLibraryFiles() {
        val `package` = get(Prompts.GROUP_ID)!!.replace('/', '.')
        Paths.get("$hyphenatedProjectName/src/main/java/$`package`").createDirectories()
        writeManifestAt(hyphenatedProjectName)
    }

    context(Prompter)
    private fun FileWriter.writeRootFiles() {
        writeTo(".gitignore", """
            *.iml
            .gradle
            /local.properties
            /.idea
            .DS_Store
            /build
            /captures
            .externalNativeBuild
            .cxx
            local.properties
        """)
        writeTo("build.gradle.kts", """
            buildscript {
                repositories {
                    google()
                    mavenCentral()
                }
            
                dependencies {
                    classpath(Plugins.GRADLE)
                    classpath(Plugins.KOTLIN)
                }
            }
            
            allprojects {
                repositories {
                    aurelius(project)
                    google()
                    mavenCentral()
                }
            }
            
            tasks.register<Delete>("clean") {
                delete(rootProject.buildDir)
            }
        """)

        @Suppress("SpellCheckingInspection")
        writeTo("gradle.properties", """
            org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
            android.useAndroidX=true
            kotlin.code.style=official
            android.nonTransitiveRClass=true
        """)

        @Suppress("SpellCheckingInspection")
        writeTo("gradlew", """
            #!/usr/bin/env sh
            
            #
            # Copyright 2015 the original author or authors.
            #
            # Licensed under the Apache License, Version 2.0 (the "License");
            # you may not use this file except in compliance with the License.
            # You may obtain a copy of the License at
            #
            #      https://www.apache.org/licenses/LICENSE-2.0
            #
            # Unless required by applicable law or agreed to in writing, software
            # distributed under the License is distributed on an "AS IS" BASIS,
            # WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
            # See the License for the specific language governing permissions and
            # limitations under the License.
            #
            
            ##############################################################################
            ##
            ##  Gradle start up script for UN*X
            ##
            ##############################################################################
            
            # Attempt to set APP_HOME
            # Resolve links: ${'$'}0 may be a link
            PRG="${'$'}0"
            # Need this for relative symlinks.
            while [ -h "${'$'}PRG" ] ; do
                ls=`ls -ld "${'$'}PRG"`
                link=`expr "${'$'}ls" : '.*-> \(.*\)${'$'}'`
                if expr "${'$'}link" : '/.*' > /dev/null; then
                    PRG="${'$'}link"
                else
                    PRG=`dirname "${'$'}PRG"`"/${'$'}link"
                fi
            done
            SAVED="`pwd`"
            cd "`dirname \"${'$'}PRG\"`/" >/dev/null
            APP_HOME="`pwd -P`"
            cd "${'$'}SAVED" >/dev/null
            
            APP_NAME="Gradle"
            APP_BASE_NAME=`basename "${'$'}0"`
            
            # Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
            DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'
            
            # Use the maximum available, or set MAX_FD != -1 to use that value.
            MAX_FD="maximum"
            
            warn () {
                echo "${'$'}*"
            }
            
            die () {
                echo
                echo "${'$'}*"
                echo
                exit 1
            }
            
            # OS specific support (must be 'true' or 'false').
            cygwin=false
            msys=false
            darwin=false
            nonstop=false
            case "`uname`" in
              CYGWIN* )
                cygwin=true
                ;;
              Darwin* )
                darwin=true
                ;;
              MINGW* )
                msys=true
                ;;
              NONSTOP* )
                nonstop=true
                ;;
            esac
            
            CLASSPATH=${'$'}APP_HOME/gradle/wrapper/gradle-wrapper.jar
            
            
            # Determine the Java command to use to start the JVM.
            if [ -n "${'$'}JAVA_HOME" ] ; then
                if [ -x "${'$'}JAVA_HOME/jre/sh/java" ] ; then
                    # IBM's JDK on AIX uses strange locations for the executables
                    JAVACMD="${'$'}JAVA_HOME/jre/sh/java"
                else
                    JAVACMD="${'$'}JAVA_HOME/bin/java"
                fi
                if [ ! -x "${'$'}JAVACMD" ] ; then
                    die "ERROR: JAVA_HOME is set to an invalid directory: ${'$'}JAVA_HOME
            
            Please set the JAVA_HOME variable in your environment to match the
            location of your Java installation."
                fi
            else
                JAVACMD="java"
                which java >/dev/null 2>&1 || die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
            
            Please set the JAVA_HOME variable in your environment to match the
            location of your Java installation."
            fi
            
            # Increase the maximum file descriptors if we can.
            if [ "${'$'}cygwin" = "false" -a "${'$'}darwin" = "false" -a "${'$'}nonstop" = "false" ] ; then
                MAX_FD_LIMIT=`ulimit -H -n`
                if [ ${'$'}? -eq 0 ] ; then
                    if [ "${'$'}MAX_FD" = "maximum" -o "${'$'}MAX_FD" = "max" ] ; then
                        MAX_FD="${'$'}MAX_FD_LIMIT"
                    fi
                    ulimit -n ${'$'}MAX_FD
                    if [ ${'$'}? -ne 0 ] ; then
                        warn "Could not set maximum file descriptor limit: ${'$'}MAX_FD"
                    fi
                else
                    warn "Could not query maximum file descriptor limit: ${'$'}MAX_FD_LIMIT"
                fi
            fi
            
            # For Darwin, add options to specify how the application appears in the dock
            if ${'$'}darwin; then
                GRADLE_OPTS="${'$'}GRADLE_OPTS \"-Xdock:name=${'$'}APP_NAME\" \"-Xdock:icon=${'$'}APP_HOME/media/gradle.icns\""
            fi
            
            # For Cygwin or MSYS, switch paths to Windows format before running java
            if [ "${'$'}cygwin" = "true" -o "${'$'}msys" = "true" ] ; then
                APP_HOME=`cygpath --path --mixed "${'$'}APP_HOME"`
                CLASSPATH=`cygpath --path --mixed "${'$'}CLASSPATH"`
            
                JAVACMD=`cygpath --unix "${'$'}JAVACMD"`
            
                # We build the pattern for arguments to be converted via cygpath
                ROOTDIRSRAW=`find -L / -maxdepth 1 -mindepth 1 -type d 2>/dev/null`
                SEP=""
                for dir in ${'$'}ROOTDIRSRAW ; do
                    ROOTDIRS="${'$'}ROOTDIRS${'$'}SEP${'$'}dir"
                    SEP="|"
                done
                OURCYGPATTERN="(^(${'$'}ROOTDIRS))"
                # Add a user-defined pattern to the cygpath arguments
                if [ "${'$'}GRADLE_CYGPATTERN" != "" ] ; then
                    OURCYGPATTERN="${'$'}OURCYGPATTERN|(${'$'}GRADLE_CYGPATTERN)"
                fi
                # Now convert the arguments - kludge to limit ourselves to /bin/sh
                i=0
                for arg in "${'$'}@" ; do
                    CHECK=`echo "${'$'}arg"|egrep -c "${'$'}OURCYGPATTERN" -`
                    CHECK2=`echo "${'$'}arg"|egrep -c "^-"`                                 ### Determine if an option
            
                    if [ ${'$'}CHECK -ne 0 ] && [ ${'$'}CHECK2 -eq 0 ] ; then                    ### Added a condition
                        eval `echo args${'$'}i`=`cygpath --path --ignore --mixed "${'$'}arg"`
                    else
                        eval `echo args${'$'}i`="\"${'$'}arg\""
                    fi
                    i=`expr ${'$'}i + 1`
                done
                case ${'$'}i in
                    0) set -- ;;
                    1) set -- "${'$'}args0" ;;
                    2) set -- "${'$'}args0" "${'$'}args1" ;;
                    3) set -- "${'$'}args0" "${'$'}args1" "${'$'}args2" ;;
                    4) set -- "${'$'}args0" "${'$'}args1" "${'$'}args2" "${'$'}args3" ;;
                    5) set -- "${'$'}args0" "${'$'}args1" "${'$'}args2" "${'$'}args3" "${'$'}args4" ;;
                    6) set -- "${'$'}args0" "${'$'}args1" "${'$'}args2" "${'$'}args3" "${'$'}args4" "${'$'}args5" ;;
                    7) set -- "${'$'}args0" "${'$'}args1" "${'$'}args2" "${'$'}args3" "${'$'}args4" "${'$'}args5" "${'$'}args6" ;;
                    8) set -- "${'$'}args0" "${'$'}args1" "${'$'}args2" "${'$'}args3" "${'$'}args4" "${'$'}args5" "${'$'}args6" "${'$'}args7" ;;
                    9) set -- "${'$'}args0" "${'$'}args1" "${'$'}args2" "${'$'}args3" "${'$'}args4" "${'$'}args5" "${'$'}args6" "${'$'}args7" "${'$'}args8" ;;
                esac
            fi
            
            # Escape application args
            save () {
                for i do printf %s\\n "${'$'}i" | sed "s/'/'\\\\''/g;1s/^/'/;\${'$'}s/\${'$'}/' \\\\/" ; done
                echo " "
            }
            APP_ARGS=`save "${'$'}@"`
            
            # Collect all arguments for the java command, following the shell quoting and substitution rules
            eval set -- ${'$'}DEFAULT_JVM_OPTS ${'$'}JAVA_OPTS ${'$'}GRADLE_OPTS "\"-Dorg.gradle.appname=${'$'}APP_BASE_NAME\"" -classpath "\"${'$'}CLASSPATH\"" org.gradle.wrapper.GradleWrapperMain "${'$'}APP_ARGS"
            
            exec "${'$'}JAVACMD" "${'$'}@"
        """)

        writeTo(
            "local.properties",
            "sdk.dir=/Users/${System.getProperty("user.name")}/Library/Android/sdk"
        )
        writeTo("settings.gradle.kts", "rootProject.name = \"${get(Prompts.PROJECT_NAME)}\"\n")
    }

    private fun FileWriter.writeManifestAt(directoryPath: String) {
        writeTo("$directoryPath/AndroidManifest.xml", """
            <?xml version="1.0" encoding="utf-8"?>
            <manifest />
        """)
    }
}

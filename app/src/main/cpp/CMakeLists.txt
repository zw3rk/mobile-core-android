
# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.10.2)

# Declares and names the project.

project("mobile_core_android")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
             mobile_core_android

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             mobile_core_android.cpp )

add_library( mobile-core STATIC IMPORTED )
set_target_properties( mobile-core PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libHSmobile-core-0.1.0.0-HfUuggbqw4DC9ci8Blc8Tf-ghc8.10.7.a)

add_library( ffi STATIC IMPORTED )
set_target_properties( ffi PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libffi.a)

add_library( gmp STATIC IMPORTED )
set_target_properties( gmp PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libgmp.a)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# find libc
find_library( c-lib
              c )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       mobile_core_android

                       # Our Haskell library, as well as ffi and gmp,
                       # on which our haskell ibrary depends.
                       mobile-core
                       ffi
                       gmp

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib}
                       ${c-lib} )

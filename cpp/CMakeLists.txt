cmake_minimum_required(VERSION 3.16)
project(playground LANGUAGES CXX C)

set(CMAKE_CXX_STANDARD 26)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

add_executable(playground
        playground/Main.cpp
)

target_include_directories(playground
        PRIVATE ${CMAKE_SOURCE_DIR}/playground
        PRIVATE ${CMAKE_SOURCE_DIR}/algorithms
)

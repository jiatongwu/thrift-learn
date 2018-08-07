QT -= gui

CONFIG += c++11 console
CONFIG -= app_bundle

QMAKE_CXXFLAGS  +=   -DHAVE_INTTYPES_H -DHAVE_NETINET_IN_H -DFORCE_BOOST_SMART_PTR
# -std=c++0x
# -Wall
             INCLUDEPATH += -l/usr/local/include/thrift
# INCLUDEPATH += -l/usr/include/boost
  INCLUDEPATH += -l/usr/include/event2
             LIBS += -L/usr/local/lib
             LIBS += -L/usr/lib/x86_64-linux-gnu/ -lthriftnb -levent -lthrift
# -lrt -lboost_thread
# The following define makes your compiler emit warnings if you use
# any feature of Qt which as been marked deprecated (the exact warnings
# depend on your compiler). Please consult the documentation of the
# deprecated API in order to know how to port your code away from it.
DEFINES += QT_DEPRECATED_WARNINGS

# You can also make your code fail to compile if you use deprecated APIs.
# In order to do so, uncomment the following line.
# You can also select to disable deprecated APIs only up to a certain version of Qt.
#DEFINES += QT_DISABLE_DEPRECATED_BEFORE=0x060000    # disables all the APIs deprecated before Qt 6.0.0

SOURCES += \
    ../../../../下载/thrift-learn-master/src/main/resources/gen-cpp/demoHello_constants.cpp \
    ../../../../下载/thrift-learn-master/src/main/resources/gen-cpp/demoHello_types.cpp \
    ../../../../下载/thrift-learn-master/src/main/resources/gen-cpp/HelloWorldService_server.skeleton.cpp \
    ../../../../下载/thrift-learn-master/src/main/resources/gen-cpp/HelloWorldService.cpp \
    ../../../../下载/thrift-learn-master/src/main/resources/gen-cpp/server.cpp

HEADERS += \
    ../../../../下载/thrift-learn-master/src/main/resources/gen-cpp/demoHello_constants.h \
    ../../../../下载/thrift-learn-master/src/main/resources/gen-cpp/demoHello_types.h \
    ../../../../下载/thrift-learn-master/src/main/resources/gen-cpp/HelloWorldService.h

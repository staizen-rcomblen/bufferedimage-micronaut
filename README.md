## Example to reproduce issues with image manipulation with Micronaut and native image

build:
 - `./mvnw clean package  -Dpackaging=native-image -DskipTests`
execute:
 - `./target/bufferedimage-micronaut -Dmicronaut.env.deduction=false`

call:
 - `curl http://localhost:8080/image`

get the stacktrace:

    12:11:13.533 [default-nioEventLoopGroup-1-2] ERROR i.m.http.server.RouteExecutor - Unexpected error occurred: java.awt.image.ColorModel.pData
    java.lang.NoSuchFieldError: java.awt.image.ColorModel.pData
    	at com.oracle.svm.core.jni.functions.JNIFunctions$Support.getFieldID(JNIFunctions.java:1271)
    	at com.oracle.svm.core.jni.functions.JNIFunctions.GetFieldID(JNIFunctions.java:425)
    	at java.desktop@17.0.5/java.awt.image.ColorModel.initIDs(ColorModel.java)
    	at java.desktop@17.0.5/java.awt.image.ColorModel.<clinit>(ColorModel.java:221)
    	at java.desktop@17.0.5/java.awt.image.BufferedImage.<clinit>(BufferedImage.java:286)
    	at bufferedimage.micronaut.BufferedImageController.image(BufferedImageController.java:20)




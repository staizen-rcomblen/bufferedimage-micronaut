package bufferedimage.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class BufferedImageController {

    @Get("/image")
    @Produces(value = {"image/png"})
    byte[] image() {

        BufferedImage image = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
        int transparent = new Color(0, 0, 0, 0).getRGB();
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                image.setRGB(i, j, transparent);
            }
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return baos.toByteArray();
    }

}

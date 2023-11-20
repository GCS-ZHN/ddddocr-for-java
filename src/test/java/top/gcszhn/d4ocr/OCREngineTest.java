/*
 * Copyright © 2022 <a href="mailto:zhang.h.n@foxmail.com">Zhang.H.N</a>.
 *
 * Licensed under the Apache License, Version 2.0 (thie "License");
 * You may not use this file except in compliance with the license.
 * You may obtain a copy of the License at
 *
 *       http://wwww.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language govering permissions and
 * limitations under the License.
 */
package top.gcszhn.d4ocr;

import org.junit.Before;
import org.junit.Test;
import top.gcszhn.d4ocr.utils.IOUtils;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class OCREngineTest {
    private OCREngine engine;

    @Before
    public void beforeTest() {
        engine = OCREngine.instance();
    }

    @Test
    public void recognizeTest() throws IOException {
        String[] name = {
                "AENZ", "ALNQ", "KVXZ", "DKQT", "极速换新", "8A62N1", "九乘六等于？", "jepv"
        };
        for (String value : name) {
            for (int i=0; i < 50; i++) {
                BufferedImage image = IOUtils.read("testData/" + value + ".png");
                String predict = engine.recognize(image);
                if (predict == null) predict = "";
                System.out.printf("Predict: %s, True: %s\n", predict, value);
                Runtime runtime = Runtime.getRuntime();
                System.out.printf("Memory: %dMB/%dMB\n", 
                    (runtime.totalMemory() - runtime.freeMemory()) >> 20, 
                    runtime.maxMemory() >> 20 );
            }
        }
    }
}

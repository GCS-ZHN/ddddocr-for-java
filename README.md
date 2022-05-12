# ddddocr-for-java
<div style="text-align: center">

![AUR](https://img.shields.io/badge/license-Apache%202.0-blue.svg)
![Java](https://img.shields.io/badge/Java%2014.0.2-passing-success.svg)
![Maven](https://img.shields.io/badge/Maven%203.6.3-building-success.svg)

</div>

基于[sml2h3](https://github.com/sml2h3)开源的[ddddocr](https://github.com/sml2h3/ddddocr)构建的java开源项目。源项目只提供pypi版本，不能满足java开发者的需求，特此尝试开发本项目。

## 基本使用
目前只支持了ddddocr的OCR功能，使用了`common_old.onnx`模型。可以通过`mvn install`安装项目或者使用[github packages源](https://github.com/GCS-ZHN/ddddocr-for-java/packages)，并添加maven依赖。
```xml
<dependency>
    <groupId>top.gcszhn</groupId>
    <artifactId>d4ocr</artifactId>
    <version>1.0</version>
</dependency>
```
下面是简单的示例代码
```java
import java.awt.image.BufferedImage;

import top.gcszhn.d4ocr.OCREngine;
import top.gcszhn.d4ocr.utils.IOUtils;

public class Test {
    public static void main(String[] args) {
         OCREngine engine = OCREngine.instance();
         BufferedImage image = IOUtils.read("AENZ.png");
         String predict = engine.recognize(image);
         System.out.println(predict);
    }
}
```

## 声明
模型版权归原作者[sml2h3](https://github.com/sml2h3)所有，仅供学习交流使用，任何问题欢迎发issue或加入[Telegram交流群](https://t.me/zjuers)。

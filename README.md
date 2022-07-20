# ddddocr-for-java
<div style="text-align: center">

![AUR](https://img.shields.io/badge/license-Apache%202.0-blue.svg)
![Java](https://img.shields.io/badge/Java%2011-passing-success.svg)
![Maven](https://img.shields.io/badge/Maven%203.6.3-building-success.svg)

</div>

基于[sml2h3](https://github.com/sml2h3)开源的[ddddocr](https://github.com/sml2h3/ddddocr)构建的java开源项目。源项目只提供pypi版本，不能满足java开发者的需求，特此尝试开发本项目。

## 基本使用
目前只支持了ddddocr的OCR功能，使用了`common_old.onnx`模型。可以通过`mvn install`安装项目或者使用[github packages源](https://github.com/GCS-ZHN/ddddocr-for-java/packages)，并添加maven依赖。
```xml
   <repositories>
        <repository>
            <id>github</id>
            <url>https://maven.pkg.github.com/gcs-zhn/ddddocr-for-java</url>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>
    <dependency>
        <groupId>top.gcszhn</groupId>
        <artifactId>d4ocr</artifactId>
        <version>1.0</version>
    </dependency>
```
同时github的maven registry要求[登录认证](https://cwiki.apache.org/confluence/display/MAVEN/DependencyResolutionException)，即只允许github用户下载，不像maven中央仓库无需注册即可下载。具体配置有[官方文档](https://docs.github.com/cn/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry)，主要是在`settings.xml`中配置server，注意token不是登录密码，需要自行创建，[快捷链接](https://github.com/settings/tokens)。
```xml
  <servers>
      <server>
      <id>github</id>
      <username>你的github账号</username>
      <password>你的github创建的具有下载package权限的token</password>
    </server>
   </servers>
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
模型版权归原作者[sml2h3](https://github.com/sml2h3)所有，仅供学习交流使用，任何问题欢迎发issue。


## 温馨提示
编译版本使用java 11编译，字节码版本号为55，低版本java使用会报错，可以选择克隆本项目手动打包或者升级java（PS：java都17了，别坚守java 1.8了）。

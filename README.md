# certificate-generator
custom certificate image generation by modifying template

生成包含自定义数据的证书图片，通过修改证书模板完成

首先将制作证书docx格式的模板，其中包含不带有信息的证书图片，需要替换信息的标记位置（文件中的关键字，比如${name}）

然后通过libreoffice，将docx文件转成pdf文件，程序需要依赖libreoffice服务

最后将pdf文件转成自定义后缀的图片

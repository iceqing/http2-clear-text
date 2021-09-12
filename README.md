# http2-clear-text

H2C(HTTP/2 Clear Text) Java实现

>背景，随着云原生相关技术的发展，服务间调用变得愈发重要，其中http2将扮演重要角色。在内网中相互调用一般是不需要进行加密解密的，
>不然会造成性能下降，对部分对性能有要求的服务来，这显得不可接受。所以我断定，h2c一定会成为未来RPC技术的一个重要发展方向。所以决定
>整理下常见语言的h2c支持情况与示例。

* gGpc已经有相关h2c实现
* Dubbo 3是否也对 h2c 做了相关实现。

各个工具h2c工具支持情况。
[http2-spec](https://github.com/httpwg/http2-spec/wiki/Implementations)

Java 相关工具对H2支持情况



| 项目              |        | h2支持情况                    | 角色          |
| ----------------- | ------ | ----------------------------- | ------------- |
| Apache HttpClient |        | h2                            | Client        |
| ok-http           |        | h2                            | Client        |
| Netty             |        | h2,h2c                        | Client/Server |
| reactor-netty-http |        | h2,h2c                        | Client/Server |
| Tomcat            |  8.5+  | h2, h2c                       | Server        |
| Jetty             |        | h2, h2-17, h2-14, h2c, h2c-17 | Server        |
| Nginx             | 1.9.5+ | server                        | h2, h2c       |



spring boot 2.5.0
自动开启h2c
Automatically enable h2c when HTTP/2 is enabled without SSL #25856

参考：
[Tomcat/jetty 支持 Http2 的H2c](https://blog.csdn.net/sinat_33189520/article/details/103716544)
[阿里集团业务驱动的升级 —— 聊一聊Dubbo 3.0 的演进思路](https://mp.weixin.qq.com/s/rAXzEcEWJelUJVc69Hz_jw)

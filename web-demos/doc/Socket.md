参考
https://www.cnblogs.com/jiangzhaowei/p/8781635.html     
https://segmentfault.com/a/1190000014044351

#### Socket是什么？
socket起源于UNIX，在Unix一切皆文件哲学的思想下，socket是一种"打开—读/写—关闭"模式的实现    

Socket 其实并不是一个协议。它工作在 `OSI 模型会话层（第5层）`，是为了方便大家直接使用更底层协议（一般是 TCP 或 UDP ）而存在的一个抽象层。

最早的一套 Socket API 是 Berkeley sockets ，采用 C 语言实现。它是 Socket 的事实标准，POSIX sockets 是基于它构建的，多种编程语言都遵循这套 API，在 JAVA、Python 中都能看到这套 API 的影子。

Socket是应用层与传输层(TCP/UDP)通信的中间软件抽象层，它是一组接口。在设计模式中，Socket其实就是一个门面模式，它把复杂的TCP/IP协议族隐藏在Socket接口后面，对用户来说，一组简单的接口就是全部，让Socket去组织数据，以符合指定的协议。


SOCK是socket的缩写



controller处理的最佳实践

> 为所有状态码定义的父类StatusCode,各个不同业务需要用的的状态码，都实现它。

> 使用ResultVo统一封装返回结果。ps(遇到一个错误：org.springframework.web.HttpMediaTypeNotAcceptableException: Could not find acceptable representation)，
> 原因是因为没给ResultVo加上set get方法,导致spring无法封装。

> 定义自己的校验异常结果返回类,Spring validation校验失败，会抛出BindException,
> 使用Advice切面和异常捕获。

> 用切面加强，实现不用手动封装结果类

> 对于有些接口，不需要包装，自定义注解

> 自定义异常及其捕获，这样就能直接抛出异常，而不用关心前端需要什么返回值。
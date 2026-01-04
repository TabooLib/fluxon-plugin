package org.tabooproject.fluxon.profiler

import jdk.jfr.*

/**
 * 脚本执行事件
 */
@Name("fluxon.ScriptExecution")
@Category("Fluxon", "Script")
@Label("Script Execution")
@Description("Fluxon 脚本执行事件")
@StackTrace(false)
class ScriptExecutionEvent : Event() {
    @Label("Script ID")
    var scriptId: String = ""
    
    @Label("Has Variables")
    var hasVariables: Boolean = false
    
    @Label("Variable Count")
    var variableCount: Int = 0
}

/**
 * 解释器执行事件
 */
@Name("fluxon.InterpreterExecution")
@Category("Fluxon", "Interpreter")
@Label("Interpreter Execution")
@Description("Fluxon 解释器执行事件")
@StackTrace(false)
class InterpreterExecutionEvent : Event() {
    @Label("Script Content")
    var scriptContent: String = ""
    @Label("Use Cache")
    var useCache: Boolean = false
    @Label("Cache Hit")
    var cacheHit: Boolean = false
    @Label("Parsed Block Count")
    var parsedBlockCount: Int = 0
}

/**
 * 环境创建事件
 */
@Name("fluxon.EnvironmentCreation")
@Category("Fluxon", "Runtime")
@Label("Environment Creation")
@Description("Fluxon 运行环境创建事件")
@StackTrace(false)
class EnvironmentCreationEvent : Event() {
    @Label("Context")
    var context: String = ""
}

/**
 * 函数调用事件
 */
@Name("fluxon.FunctionCall")
@Category("Fluxon", "Function")
@Label("Function Call")
@Description("Fluxon 函数调用事件")
@StackTrace(false)
class FunctionCallEvent : Event() {
    @Label("Function Name")
    var functionName: String = ""
    @Label("Argument Count")
    var argumentCount: Int = 0
    @Label("Has Target")
    var hasTarget: Boolean = false
    @Label("Target Type")
    var targetType: String = ""
}

/**
 * 脚本编译事件
 */
@Name("fluxon.ScriptCompilation")
@Category("Fluxon", "Compiler")
@Label("Script Compilation")
@Description("Fluxon 脚本编译事件")
@StackTrace(false)
class ScriptCompilationEvent : Event() {
    @Label("Script ID")
    var scriptId: String = ""
    @Label("Script Size")
    var scriptSize: Int = 0
    @Label("Class Name")
    var className: String = ""
}

/**
 * 缓存访问事件
 */
@Name("fluxon.CacheAccess")
@Category("Fluxon", "Cache")
@Label("Cache Access")
@Description("Fluxon 缓存访问事件")
@StackTrace(false)
class CacheAccessEvent : Event() {
    @Label("Cache Key")
    var cacheKey: String = ""
    @Label("Hit")
    var hit: Boolean = false
    @Label("Cache Size")
    var cacheSize: Int = 0
}
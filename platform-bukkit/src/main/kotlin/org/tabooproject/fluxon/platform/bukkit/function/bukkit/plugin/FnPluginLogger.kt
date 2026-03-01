package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.plugin.PluginLogger
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.logging.LogRecord
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.plugin.PluginLogger"])
@PlatformSide(Platform.BUKKIT)
object FnPluginLogger {

    val TYPE = Type.fromClass(PluginLogger::class.java)
    private val LOG_RECORD = Type.fromClass(LogRecord::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginLogger::class.java)
                .function("log", returnsVoid().params(LOG_RECORD)) { it.target?.log(it.getRef(0) as LogRecord) }
        }
    }
}

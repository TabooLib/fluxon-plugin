package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file

import org.bukkit.configuration.file.FileConfiguration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.io.File
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.configuration.file.FileConfiguration"])
@PlatformSide(Platform.BUKKIT)
object FnFileConfiguration {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FileConfiguration::class.java)
                .function("save", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.save(it.getString(0)!!)) }
                .function("saveToString", returnsObject().noParams()) { it.setReturnRef(it.target?.saveToString()) }
                .function("load", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is File -> it.target?.load(var1)
                        is String -> it.target?.load(var1)
                        else -> throw IllegalArgumentException("参数必须是 File 或 String 类型")
                    })
                }
                .function("loadFromString", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.loadFromString(it.getString(0)!!)) }
        }
    }
}

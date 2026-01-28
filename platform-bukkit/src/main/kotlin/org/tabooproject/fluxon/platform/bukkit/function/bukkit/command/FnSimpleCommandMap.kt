package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.SimpleCommandMap
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.command.SimpleCommandMap"])
@PlatformSide(Platform.BUKKIT)
object FnSimpleCommandMap {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SimpleCommandMap::class.java)
                .function("setFallbackCommands", returnsObject().noParams()) { it.setReturnRef(it.target?.setFallbackCommands()) }
                .function("registerAll", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.registerAll(
                        it.getString(0)!!,
                        it.getRef(1) as List<Command>
                    ))
                }
                .function("register", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.register(it.getString(0)!!, it.getRef(1) as Command)
                    } else {
                        it.target?.register(
                            it.getString(0)!!,
                            it.getString(1)!!,
                            it.getRef(2) as Command
                        )
                    })
                }
                .function("register", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.register(it.getString(0)!!, it.getRef(1) as Command)
                    } else {
                        it.target?.register(
                            it.getString(0)!!,
                            it.getString(1)!!,
                            it.getRef(2) as Command
                        )
                    })
                }
                .function("dispatch", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.dispatch(it.getRef(0) as CommandSender, it.getString(1)!!)) }
                .function("getCommand", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getCommand(it.getString(0)!!)) }
                .function("tabComplete", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.tabComplete(
                            it.getRef(0) as CommandSender,
                            it.getString(1)!!
                        )
                    } else {
                        it.target?.tabComplete(
                            it.getRef(0) as CommandSender,
                            it.getString(1)!!,
                            it.getRef(2) as Location
                        )
                    })
                }
                .function("tabComplete", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.tabComplete(
                            it.getRef(0) as CommandSender,
                            it.getString(1)!!
                        )
                    } else {
                        it.target?.tabComplete(
                            it.getRef(0) as CommandSender,
                            it.getString(1)!!,
                            it.getRef(2) as Location
                        )
                    })
                }
                .function("commands", returnsObject().noParams()) { it.setReturnRef(it.target?.commands) }
                .function("registerServerAliases", returnsObject().noParams()) { it.setReturnRef(it.target?.registerServerAliases()) }
        }
    }
}

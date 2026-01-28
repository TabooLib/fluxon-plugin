package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandMap
import org.bukkit.command.CommandSender
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.command.CommandMap"])
@PlatformSide(Platform.BUKKIT)
object FnCommandMap {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandMap::class.java)
                .function("registerAll", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.registerAll(
                        it.getString(0)!!,
                        it.getRef(1) as List<Command>
                    )
                }
                .function("register", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.register(it.getString(0)!!, it.getRef(1) as Command)
                    } else {
                        it.target?.register(
                            it.getString(0)!!,
                            it.getString(1)!!,
                            it.getRef(2) as Command
                        )
                    }
                }
                .function("register", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        it.target?.register(it.getString(0)!!, it.getRef(1) as Command)
                    } else {
                        it.target?.register(
                            it.getString(0)!!,
                            it.getString(1)!!,
                            it.getRef(2) as Command
                        )
                    }
                }
                .function("dispatch", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.dispatch(it.getRef(0) as CommandSender, it.getString(1)!!) }
                .function("clearCommands", returnsObject().noParams()) { it.target?.clearCommands() }
                .function("getCommand", returnsObject().params(Type.OBJECT)) { it.target?.getCommand(it.getString(0)!!) }
                .function("tabComplete", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
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
                    }
                }
                .function("tabComplete", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
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
                    }
                }
        }
    }
}

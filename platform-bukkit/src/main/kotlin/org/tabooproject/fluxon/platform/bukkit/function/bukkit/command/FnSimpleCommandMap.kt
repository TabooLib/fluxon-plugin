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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.command.SimpleCommandMap"])
@PlatformSide(Platform.BUKKIT)
object FnSimpleCommandMap {

    val TYPE = Type.fromClass(SimpleCommandMap::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SimpleCommandMap::class.java)
                .function("setFallbackCommands", returnsVoid().noParams()) { it.target?.setFallbackCommands() }
                .function("registerAll", returnsVoid().params(Type.STRING, Type.LIST)) {
                    it.target?.registerAll(
                        it.getString(0)!!,
                        it.getRef(1) as List<Command>
                    )
                }
                .function("register", returns(Type.Z).params(Type.STRING, Type.OBJECT)) {
                    it.setReturnBool(it.target?.register(it.getString(0)!!, it.getRef(1) as Command) == true)
                }
                .function("register", returns(Type.Z).params(Type.STRING, Type.STRING, Type.OBJECT)) {
                    it.setReturnBool(
                        it.target?.register(
                            it.getString(0)!!,
                            it.getString(1)!!,
                            it.getRef(2) as Command
                        ) == true
                    )
                }
                .function("dispatch", returns(Type.Z).params(Type.OBJECT, Type.STRING)) {
                    it.setReturnBool(it.target?.dispatch(it.getRef(0) as CommandSender, it.getString(1)!!) == true)
                }
                .function("getCommand", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getCommand(it.getString(0)!!)) }
                .function("tabComplete", returnsObject().params(Type.OBJECT, Type.STRING)) {
                    it.setReturnRef(
                        it.target?.tabComplete(
                            it.getRef(0) as CommandSender,
                            it.getString(1)!!
                        )
                    )
                }
                .function("tabComplete", returnsObject().params(Type.OBJECT, Type.STRING, Type.OBJECT)) {
                    it.setReturnRef(
                        it.target?.tabComplete(
                            it.getRef(0) as CommandSender,
                            it.getString(1)!!,
                            it.getRef(2) as Location
                        )
                    )
                }
                .function("commands", returnsObject().noParams()) { it.setReturnRef(it.target?.commands) }
                .function("registerServerAliases", returnsVoid().noParams()) { it.target?.registerServerAliases() }
        }
    }
}

package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandMap
import org.bukkit.command.CommandSender
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.command.Command"])
@PlatformSide(Platform.BUKKIT)
object FnCommand {

    val TYPE = Type.fromClass(Command::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Command::class.java)
//                .function("timings", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.timings) }
//                .function("setTimings", returns(Type.OBJECT).params(Type.OBJECT)) { it.setReturnRef(it.target?.timings = it.getRef(0) as CustomTimingsHandler) }
                .function("execute", returns(Type.Z).params(FnCommandSender.TYPE, Type.STRING, Type.LIST)) {
                    it.setReturnBool(it.target?.execute(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!,
                        (it.getRef(2) as List<String>).toTypedArray(),
                    ) ?: false)
                }
                .function("tabComplete", returns(Type.LIST).params(FnCommandSender.TYPE, Type.STRING, Type.LIST)) {
                    it.setReturnRef(it.target?.tabComplete(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!,
                        (it.getRef(2) as List<String>).toTypedArray(),
                    ))
                }
                .function("tabComplete", returns(Type.LIST).params(FnCommandSender.TYPE, Type.STRING, Type.LIST,
                    FnLocation.TYPE)) {
                    it.setReturnRef(it.target?.tabComplete(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!,
                        (it.getRef(2) as List<String>).toTypedArray(),
                        it.getRef(3) as Location
                    ))
                }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("setName", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.setName(it.getString(0)!!) ?: false) }
                .function("permission", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.permission) }
                .function("setPermission", returnsVoid().params(Type.STRING)) { it.target?.setPermission(it.getString(0)) }
                .function("testPermission", returns(Type.Z).params(FnCommandSender.TYPE)) {
                    it.setReturnBool(it.target?.testPermission(it.getRef(0) as CommandSender) ?: false)
                }
                .function("testPermissionSilent", returns(Type.Z).params(FnCommandSender.TYPE)) {
                    it.setReturnBool(it.target?.testPermissionSilent(it.getRef(0) as CommandSender) ?: false)
                }
                .function("label", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.label) }
                .function("setLabel", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.setLabel(it.getString(0)!!) ?: false) }
                .function("register",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandMap.TYPE)) {
                    it.setReturnBool(it.target?.register(it.getRef(0) as CommandMap) ?: false)
                }
                .function("unregister", returns(Type.Z).params(FnCommandMap.TYPE)) {
                    it.setReturnBool(it.target?.unregister(it.getRef(0) as CommandMap) ?: false)
                }
                .function("isRegistered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRegistered ?: false) }
                .function("aliases", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.aliases) }
                .function("permissionMessage", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.permissionMessage) }
                .function("description", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.getDescription()) }
                .function("usage", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.usage) }
                .function("setAliases", returns(Type.Z).params(Type.LIST)) {
                    it.setReturnRef(it.target?.setAliases(it.getRef(0) as List<String>) ?: false)
                }
                .function("setDescription", returnsVoid().params(Type.STRING)) { it.target?.setDescription(it.getString(0)!!) }
                .function("setPermissionMessage", returnsVoid().params(Type.STRING)) { it.target?.setPermissionMessage(it.getString(0)) }
                .function("setUsage", returnsVoid().params(Type.STRING)) { it.target?.setUsage(it.getString(0)!!) }
                .function("broadcastCommandMessage", returnsVoid().params(FnCommandSender.TYPE, Type.STRING)) {
                    Command.broadcastCommandMessage(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!
                    )
                }
                .function("broadcastCommandMessage", returnsVoid().params(FnCommandSender.TYPE, Type.STRING, Type.Z)) {
                    Command.broadcastCommandMessage(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!,
                        it.getBool(2)
                    )
                }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}

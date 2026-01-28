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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.command.Command"])
@PlatformSide(Platform.BUKKIT)
object FnCommand {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Command::class.java)
                .function("timings", returnsObject().noParams()) { it.target?.timings }
//                .function("setTimings", returnsObject().params(Type.OBJECT)) { it.target?.timings = it.getRef(0) as CustomTimingsHandler }
                .function("execute", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.execute(
                        it.getRef(0) as CommandSender,
                        it.getString(1)!!,
                        it.getRef(2) as Array<String>,
                    )
                }
                .function("tabComplete", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 3) {
                        it.target?.tabComplete(
                            it.getRef(0) as CommandSender,
                            it.getString(1)!!,
                            it.getRef(2) as Array<String>,
                        )
                    } else {
                        it.target?.tabComplete(
                            it.getRef(0) as CommandSender,
                            it.getString(1)!!,
                            it.getRef(2) as Array<String>,
                            it.getRef(3) as Location
                        )
                    }
                }
                .function("tabComplete", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 3) {
                        it.target?.tabComplete(
                            it.getRef(0) as CommandSender,
                            it.getString(1)!!,
                            it.getRef(2) as Array<String>,
                        )
                    } else {
                        it.target?.tabComplete(
                            it.getRef(0) as CommandSender,
                            it.getString(1)!!,
                            it.getRef(2) as Array<String>,
                            it.getRef(3) as Location
                        )
                    }
                }
                .function("name", returns(Type.STRING).noParams()) { it.target?.name }
                .function("setName", returnsObject().params(Type.OBJECT)) { it.target?.setName(it.getString(0)!!) }
                .function("permission", returnsObject().noParams()) { it.target?.permission }
                .function("setPermission", returnsObject().params(Type.OBJECT)) { it.target?.setPermission(it.getString(0)) }
                .function("testPermission", returnsObject().params(Type.OBJECT)) { it.target?.testPermission(it.getRef(0) as CommandSender) }
                .function("testPermissionSilent", returnsObject().params(Type.OBJECT)) { it.target?.testPermissionSilent(it.getRef(0) as CommandSender) }
                .function("label", returnsObject().noParams()) { it.target?.label }
                .function("setLabel", returnsObject().params(Type.OBJECT)) { it.target?.setLabel(it.getString(0)!!) }
                .function("register", returnsObject().params(Type.OBJECT)) { it.target?.register(it.getRef(0) as CommandMap) }
                .function("unregister", returnsObject().params(Type.OBJECT)) { it.target?.unregister(it.getRef(0) as CommandMap) }
                .function("isRegistered", returns(Type.Z).noParams()) { it.target?.isRegistered }
                .function("aliases", returnsObject().noParams()) { it.target?.aliases }
                .function("permissionMessage", returnsObject().noParams()) { it.target?.permissionMessage }
                .function("description", returnsObject().noParams()) { it.target?.getDescription() }
                .function("usage", returnsObject().noParams()) { it.target?.usage }
                .function("setAliases", returnsObject().params(Type.OBJECT)) { it.target?.setAliases(it.getRef(0) as List<String>) }
                .function("setDescription", returnsObject().params(Type.OBJECT)) { it.target?.setDescription(it.getString(0)!!) }
                .function("setPermissionMessage", returnsObject().params(Type.OBJECT)) { it.target?.setPermissionMessage(it.getString(0)) }
                .function("setUsage", returnsObject().params(Type.OBJECT)) { it.target?.setUsage(it.getString(0)!!) }
                .function("broadcastCommandMessage", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        Command.broadcastCommandMessage(it.getRef(0) as CommandSender, it.getString(1)!!)
                    } else {
                        Command.broadcastCommandMessage(
                            it.getRef(0) as CommandSender,
                            it.getString(1)!!,
                            it.getBool(2)
                        )
                    }
                }
                .function("broadcastCommandMessage", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 2) {
                        Command.broadcastCommandMessage(it.getRef(0) as CommandSender, it.getString(1)!!)
                    } else {
                        Command.broadcastCommandMessage(
                            it.getRef(0) as CommandSender,
                            it.getString(1)!!,
                            it.getBool(2)
                        )
                    }
                }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
        }
    }
}

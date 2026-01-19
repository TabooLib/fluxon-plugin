package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.CommandSender
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.function.adaptCommandSender
import java.util.*

object FnCommandSender {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandSender::class.java)
                // 橙汁喵: 自定义语法, 这个语法并不在Bukkit中存在
                .syncFunction("performCommand", 1) { adaptCommandSender(it.target!!).performCommand(it.getString(0)!!) }
                .function("sendMessage", 1) { it.target?.sendMessage(it.getString(0)) }
                .function("sendMessage", 2) {
                    it.target?.sendMessage(
                        UUID.fromString(it.getString(0)),
                        it.getString(1)
                    )
                }
                .function("server", 0) { it.target?.server }
                .function("name", 0) { it.target?.name }
        }
    }
}

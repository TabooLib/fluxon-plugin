package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import PlayerPreLoginEvent.Result
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnAsyncPlayerPreLoginEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AsyncPlayerPreLoginEvent::class.java)
                .function("loginResult", 0) { it.target?.loginResult }
                .function("setLoginResult", 1) { it.target?.setLoginResult(it.getArgument(0) as Result) }
                .function("setResult", 1) { it.target?.setResult(it.getArgument(0) as PlayerPreLoginEvent.Result) }
                .function("kickMessage", 0) { it.target?.kickMessage }
                .function("setKickMessage", 1) { it.target?.setKickMessage(it.getString(0)!!) }
                .function("allow", 0) { it.target?.allow() }
                .function("disallow", 2) {
                    // void disallow(@NotNull Result result, @NotNull String message)
                    // void disallow(@NotNull PlayerPreLoginEvent.Result result, @NotNull String message)
                    TODO()
                }
                .function("name", 0) { it.target?.name }
                .function("address", 0) { it.target?.address }
                .function("uniqueId", 0) { it.target?.uniqueId }
                .function("isTransferred", 0) { it.target?.isTransferred }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { AsyncPlayerPreLoginEvent.getHandlerList() }
        }
    }
}

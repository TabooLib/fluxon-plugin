package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.ChatPaginator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnChatPaginator {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChatPaginator::class.java)
                // static
                .function("paginate", listOf(2, 4)) {
                    if (it.arguments.size == 2) {
                        ChatPaginator.paginate(it.getString(0), it.getNumber(1).toInt())
                    } else {
                        ChatPaginator.paginate(
                            it.getString(0),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt()
                        )
                    }
                }
                // static
                .function("wordWrap", 2) { ChatPaginator.wordWrap(it.getString(0), it.getNumber(1).toInt()) }

            registerExtension(ChatPaginator.ChatPage::class.java)
                .function("pageNumber", 0) { it.target?.pageNumber }
                .function("totalPages", 0) { it.target?.totalPages }
                .function("lines", 0) { it.target?.lines }
        }
    }
}

package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.ChatPaginator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.ChatPaginator"])
@PlatformSide(Platform.BUKKIT)
object FnChatPaginator {

    val TYPE = Type.fromClass(ChatPaginator::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChatPaginator::class.java)
                // static
                .function("paginate", returnsObject().params(Type.STRING, Type.I)) {
                    it.setReturnRef(ChatPaginator.paginate(it.getString(0), it.getInt(1).toInt()))
                }
                .function("paginate", returnsObject().params(Type.STRING, Type.I, Type.I, Type.I)) {
                    it.setReturnRef(ChatPaginator.paginate(
                        it.getString(0),
                        it.getInt(1).toInt(),
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt()
                    ))
                }
                // static
                .function("wordWrap", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(ChatPaginator.wordWrap(it.getString(0), it.getInt(1).toInt())) }
        }
    }
}

@Requires(classes = ["org.bukkit.util.ChatPaginator.ChatPage"])
@PlatformSide(Platform.BUKKIT)
object FnChatPaginatorChatPage {

    val TYPE = Type.fromClass(ChatPaginator.ChatPage::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChatPaginator.ChatPage::class.java)
                .function("pageNumber", returnsObject().noParams()) { it.setReturnRef(it.target?.pageNumber) }
                .function("totalPages", returnsObject().noParams()) { it.setReturnRef(it.target?.totalPages) }
                .function("lines", returnsObject().noParams()) { it.setReturnRef(it.target?.lines) }
        }
    }
}

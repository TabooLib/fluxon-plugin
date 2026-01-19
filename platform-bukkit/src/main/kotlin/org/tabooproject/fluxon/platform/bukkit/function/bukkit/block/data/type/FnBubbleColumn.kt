package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.BubbleColumn
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBubbleColumn {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BubbleColumn::class.java)
                .function("isDrag", 0) { it.target?.isDrag }
                .function("setDrag", 1) { it.target?.setDrag(it.getBoolean(0)) }
        }
    }
}

package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.map.MapCursor
import org.bukkit.map.MapCursorCollection
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMapCursorCollection {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapCursorCollection::class.java)
                .function("size", 0) { it.target?.size() }
                .function("cursor", 1) { it.target?.getCursor(it.getNumber(0).toInt()) }
                .function("removeCursor", 1) { it.target?.removeCursor(it.getArgument(0) as MapCursor) }
                .function("addCursor", listOf(1, 3, 4, 5, 6)) {
                    when (it.arguments.size) {
                        1 -> it.target?.addCursor(it.getArgument(0) as MapCursor)
                        3 -> it.target?.addCursor(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toByte()
                        )

                        4 -> it.target?.addCursor(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toByte(),
                            it.getNumber(3).toByte()
                        )

                        5 -> it.target?.addCursor(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toByte(),
                            it.getNumber(3).toByte(),
                            it.getBoolean(4)
                        )

                        6 -> it.target?.addCursor(
                            it.getNumber(0).toInt(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toByte(),
                            it.getNumber(3).toByte(),
                            it.getBoolean(4),
                            it.getString(5)
                        )
                        else -> error("MapCursorCollection#addCursor 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
        }
    }
}

package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.map.MapCursor
import org.bukkit.map.MapCursorCollection
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnMapCursorCollection {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapCursorCollection::class.java)
                .function("size", 0) { it.target?.size() }
                .function("cursor", 1) { it.target?.getCursor(it.getNumber(0).toInt()) }
                .function("removeCursor", 1) { it.target?.removeCursor(it.getArgument(0) as MapCursor) }
                .function("addCursor", 1) { it.target?.addCursor(it.getArgument(0) as MapCursor) }
                .function("addCursor", 3) {
                    it.target?.addCursor(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toByte()
                    )
                }
                .function("addCursor", 4) {
                    it.target?.addCursor(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toByte(),
                        it.getNumber(3).toByte()
                    )
                }
                .function("addCursor", 5) {
                    it.target?.addCursor(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toByte(),
                        it.getNumber(3).toByte(),
                        it.getBoolean(4)
                    )
                }
                .function("addCursor", 6) {
                    it.target?.addCursor(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toByte(),
                        it.getNumber(3).toByte(),
                        it.getBoolean(4),
                        it.getString(5)
                    )
                }
        }
    }
}

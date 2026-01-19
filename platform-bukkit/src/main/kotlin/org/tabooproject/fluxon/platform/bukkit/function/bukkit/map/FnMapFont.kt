package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.map.MapFont
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnMapFont {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapFont::class.java)
                .function("setChar", 2) {
                    it.target?.setChar(
                        it.getString(0)?.firstOrNull()!!,
                        it.getArgument(1) as MapFont.CharacterSprite
                    )
                }
                .function("char", 1) { it.target?.getChar(it.getString(0)?.firstOrNull()!!) }
                .function("width", 1) { it.target?.getWidth(it.getString(0)!!) }
                .function("height", 0) {
                    it.target?.height
                }
                .function("isValid", 1) { it.target?.isValid(it.getString(0)!!) }

            registerExtension(MapFont.CharacterSprite::class.java)
                .function("get", 2) { it.target?.get(it.getNumber(0).toInt(), it.getNumber(1).toInt()) }
                .function("width", 0) { it.target?.width }
        }
    }
}

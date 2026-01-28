package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.map.MapFont
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.map.MapFont"])
@PlatformSide(Platform.BUKKIT)
object FnMapFont {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapFont::class.java)
                .function("setChar", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setChar(
                        it.getString(0)?.firstOrNull()!!,
                        it.getRef(1) as MapFont.CharacterSprite
                    )
                }
                .function("getChar", returnsObject().params(Type.OBJECT)) { it.target?.getChar(it.getString(0)?.firstOrNull()!!) }
                .function("getWidth", returnsObject().params(Type.OBJECT)) { it.target?.getWidth(it.getString(0)!!) }
                .function("height", returnsObject().noParams()) {
                    it.target?.height
                }
                .function("isValid", returns(Type.Z).params(Type.OBJECT)) { it.target?.isValid(it.getString(0)!!) }
        }
    }
}

@Requires(classes = ["org.bukkit.map.MapFont.CharacterSprite"])
@PlatformSide(Platform.BUKKIT)
object FnMapFontCharacterSprite {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapFont.CharacterSprite::class.java)
                .function("get", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.get(it.getInt(0).toInt(), it.getInt(1).toInt()) }
                .function("width", returnsObject().noParams()) { it.target?.width }
        }
    }
}

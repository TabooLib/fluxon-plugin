package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.map.MapFont
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.map.MapFont"])
@PlatformSide(Platform.BUKKIT)
object FnMapFont {

    val TYPE = Type.fromClass(MapFont::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapFont::class.java)
                .function("setChar",returnsVoid().params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapFontCharacterSprite.TYPE)) {
                    it.target?.setChar(
                        it.getString(0)?.firstOrNull()!!,
                        it.getRef(1) as MapFont.CharacterSprite
                    )
                }
                .function("getChar", returns(FnMapFontCharacterSprite.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getChar(it.getString(0)?.firstOrNull()!!)) }
                .function("getWidth", returns(Type.I).params(Type.STRING)) { it.setReturnInt(it.target?.getWidth(it.getString(0)!!) ?: 0) }
                .function("height", returns(Type.I).noParams()) { it.setReturnInt(it.target?.height ?: 0) }
                .function("isValid", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isValid(it.getString(0)!!) ?: false) }
        }
    }
}

@Requires(classes = ["org.bukkit.map.MapFont\$CharacterSprite"])
@PlatformSide(Platform.BUKKIT)
object FnMapFontCharacterSprite {

    val TYPE = Type.fromClass(MapFont.CharacterSprite::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapFont.CharacterSprite::class.java)
                .function("get", returns(Type.Z).params(Type.I, Type.I)) {
                    it.setReturnBool(it.target?.get(it.getInt(0).toInt(), it.getInt(1).toInt()) ?: false)
                }
                .function("width", returns(Type.I).noParams()) { it.setReturnInt(it.target?.width ?: 0) }
        }
    }
}

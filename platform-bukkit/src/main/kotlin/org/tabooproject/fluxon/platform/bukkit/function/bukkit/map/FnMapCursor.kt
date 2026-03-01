package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.map.MapCursor
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

@Requires(classes = ["org.bukkit.map.MapCursor"])
@PlatformSide(Platform.BUKKIT)
object FnMapCursor {

    val TYPE = Type.fromClass(MapCursor::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapCursor::class.java)
                .function("x", returns(Type.I).noParams()) { it.setReturnInt(it.target?.x?.toInt() ?: 0) }
                .function("y", returns(Type.I).noParams()) { it.setReturnInt(it.target?.y?.toInt() ?: 0) }
                .function("direction", returns(Type.I).noParams()) { it.setReturnInt(it.target?.direction?.toInt() ?: 0) }
                .function("type", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapCursorType.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
                .function("rawType", returns(Type.I).noParams()) { it.setReturnInt(it.target?.rawType?.toInt() ?: 0) }
                .function("isVisible", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isVisible ?: false) }
                .function("setX", returnsVoid().params(Type.I)) { it.target?.setX(it.getInt(0).toByte()) }
                .function("setY", returnsVoid().params(Type.I)) { it.target?.setY(it.getInt(0).toByte()) }
                .function("setDirection", returnsVoid().params(Type.I)) { it.target?.setDirection(it.getInt(0).toByte()) }
                .function("setType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapCursorType.TYPE)) { it.target?.setType(it.getRef(0) as MapCursor.Type) }
                .function("setRawType", returnsVoid().params(Type.I)) { it.target?.setRawType(it.getInt(0).toByte()) }
                .function("setVisible", returnsVoid().params(Type.Z)) { it.target?.setVisible(it.getBool(0)) }
                .function("caption", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.caption) }
                .function("setCaption", returnsVoid().params(Type.STRING)) { it.target?.setCaption(it.getString(0)) }
        }
    }
}

@Requires(classes = ["org.bukkit.map.MapCursor\$Type"])
@PlatformSide(Platform.BUKKIT)
object FnMapCursorType {

    val TYPE = Type.fromClass(MapCursor.Type::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapCursor.Type::class.java)
                .function("key", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE).noParams()) { it.setReturnRef(it.target?.key) }
                .function("value", returns(Type.I).noParams()) { it.setReturnInt(it.target?.value?.toInt() ?: 0) }
                // static
                .function("byValue", returns(TYPE).params(Type.I)) { it.setReturnRef(MapCursor.Type.byValue(it.getInt(0).toByte())) }
        }
    }
}

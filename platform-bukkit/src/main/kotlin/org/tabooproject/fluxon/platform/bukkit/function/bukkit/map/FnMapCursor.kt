package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.map.MapCursor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.map.MapCursor"])
@PlatformSide(Platform.BUKKIT)
object FnMapCursor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapCursor::class.java)
                .function("x", returnsObject().noParams()) { it.target?.x }
                .function("y", returnsObject().noParams()) { it.target?.y }
                .function("direction", returnsObject().noParams()) { it.target?.direction }
                .function("type", returnsObject().noParams()) { it.target?.type }
                .function("rawType", returnsObject().noParams()) { it.target?.rawType }
                .function("isVisible", returns(Type.Z).noParams()) { it.target?.isVisible }
                .function("setX", returnsObject().params(Type.OBJECT)) { it.target?.setX(it.getInt(0).toByte()) }
                .function("setY", returnsObject().params(Type.OBJECT)) { it.target?.setY(it.getInt(0).toByte()) }
                .function("setDirection", returnsObject().params(Type.OBJECT)) { it.target?.setDirection(it.getInt(0).toByte()) }
                .function("setType", returnsObject().params(Type.OBJECT)) { it.target?.setType(it.getRef(0) as MapCursor.Type) }
                .function("setRawType", returnsObject().params(Type.OBJECT)) { it.target?.setRawType(it.getInt(0).toByte()) }
                .function("setVisible", returnsObject().params(Type.OBJECT)) { it.target?.setVisible(it.getBool(0)) }
                .function("caption", returnsObject().noParams()) { it.target?.caption }
                .function("setCaption", returnsObject().params(Type.OBJECT)) { it.target?.setCaption(it.getString(0)) }
        }
    }
}

@Requires(classes = ["org.bukkit.map.MapCursor.Type"])
@PlatformSide(Platform.BUKKIT)
object FnMapCursorType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapCursor.Type::class.java)
                .function("key", returnsObject().noParams()) { it.target?.key }
                .function("value", returnsObject().noParams()) { it.target?.value }
                // static
                .function("byValue", returnsObject().params(Type.OBJECT)) { MapCursor.Type.byValue(it.getInt(0).toByte()) }
        }
    }
}

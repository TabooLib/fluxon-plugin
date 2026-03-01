package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.map.MapCursor
import org.bukkit.map.MapCursorCollection
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.map.MapCursorCollection"])
@PlatformSide(Platform.BUKKIT)
object FnMapCursorCollection {

    val TYPE = Type.fromClass(MapCursorCollection::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapCursorCollection::class.java)
                .function("size", returns(Type.I).noParams()) { it.setReturnInt(it.target?.size() ?: 0) }
                .function("getCursor", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapCursor.TYPE).params(Type.I)) { it.setReturnRef(it.target?.getCursor(it.getInt(0).toInt())) }
                .function("removeCursor",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapCursor.TYPE)) { it.target?.removeCursor(it.getRef(0) as MapCursor) }
                .function("addCursor",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapCursor.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapCursor.TYPE)) {
                    it.setReturnRef(it.target?.addCursor(it.getRef(0) as MapCursor))
                }
                .function("addCursor", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapCursor.TYPE).params(Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.addCursor(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toByte()
                    ))
                }
                .function("addCursor", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapCursor.TYPE).params(Type.I, Type.I, Type.I, Type.I)) {
                    it.setReturnRef(it.target?.addCursor(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toByte(),
                        it.getInt(3).toByte()
                    ))
                }
                .function("addCursor", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapCursor.TYPE).params(Type.I, Type.I, Type.I, Type.I, Type.Z)) {
                    it.setReturnRef(it.target?.addCursor(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toByte(),
                        it.getInt(3).toByte(),
                        it.getBool(4)
                    ))
                }
                .function("addCursor", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapCursor.TYPE).params(Type.I, Type.I, Type.I, Type.I, Type.Z, Type.STRING)) {
                    it.setReturnRef(it.target?.addCursor(
                        it.getInt(0).toInt(),
                        it.getInt(1).toInt(),
                        it.getInt(2).toByte(),
                        it.getInt(3).toByte(),
                        it.getBool(4),
                        it.getString(5)
                    ))
                }
        }
    }
}

package org.tabooproject.fluxon.platform.bukkit.function.bukkit.map

import org.bukkit.map.MapCursor
import org.bukkit.map.MapCursorCollection
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.map.MapCursorCollection"])
@PlatformSide(Platform.BUKKIT)
object FnMapCursorCollection {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MapCursorCollection::class.java)
                .function("size", returns(Type.I).noParams()) { it.setReturnRef(it.target?.size()) }
                .function("getCursor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getCursor(it.getInt(0).toInt())) }
                .function("removeCursor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeCursor(it.getRef(0) as MapCursor)) }
                .function("addCursor", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.addCursor(it.getRef(0) as MapCursor)
                        3 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte()
                        )

                        4 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte()
                        )

                        5 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte(),
                            it.getBool(4)
                        )

                        6 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte(),
                            it.getBool(4),
                            it.getString(5)
                        )
                        else -> error("MapCursorCollection#addCursor 函数参数数量错误: ${"args"}")
                    })
                }
                .function("addCursor", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.addCursor(it.getRef(0) as MapCursor)
                        3 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte()
                        )

                        4 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte()
                        )

                        5 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte(),
                            it.getBool(4)
                        )

                        6 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte(),
                            it.getBool(4),
                            it.getString(5)
                        )
                        else -> error("MapCursorCollection#addCursor 函数参数数量错误: ${"args"}")
                    })
                }
                .function("addCursor", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.addCursor(it.getRef(0) as MapCursor)
                        3 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte()
                        )

                        4 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte()
                        )

                        5 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte(),
                            it.getBool(4)
                        )

                        6 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte(),
                            it.getBool(4),
                            it.getString(5)
                        )
                        else -> error("MapCursorCollection#addCursor 函数参数数量错误: ${"args"}")
                    })
                }
                .function("addCursor", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.addCursor(it.getRef(0) as MapCursor)
                        3 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte()
                        )

                        4 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte()
                        )

                        5 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte(),
                            it.getBool(4)
                        )

                        6 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte(),
                            it.getBool(4),
                            it.getString(5)
                        )
                        else -> error("MapCursorCollection#addCursor 函数参数数量错误: ${"args"}")
                    })
                }
                .function("addCursor", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.addCursor(it.getRef(0) as MapCursor)
                        3 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte()
                        )

                        4 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte()
                        )

                        5 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte(),
                            it.getBool(4)
                        )

                        6 -> it.target?.addCursor(
                            it.getInt(0).toInt(),
                            it.getInt(1).toInt(),
                            it.getInt(2).toByte(),
                            it.getInt(3).toByte(),
                            it.getBool(4),
                            it.getString(5)
                        )
                        else -> error("MapCursorCollection#addCursor 函数参数数量错误: ${"args"}")
                    })
                }
        }
    }
}

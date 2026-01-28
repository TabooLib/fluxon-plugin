package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Location
import org.bukkit.WorldBorder
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.concurrent.TimeUnit
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.WorldBorder"])
@PlatformSide(Platform.BUKKIT)
object FnWorldBorder {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WorldBorder::class.java)
                .function("world", returnsObject().noParams()) { it.target?.world }
                .function("reset", returnsObject().noParams()) { it.target?.reset() }
                .function("size", returns(Type.I).noParams()) { it.target?.size }
                .function("setSize", returnsObject().params(Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.setSize(it.getAsDouble(0))
                        2 -> it.target?.setSize(it.getAsDouble(0), it.getInt(1).toLong())
                        3 -> it.target?.setSize(
                            it.getAsDouble(0),
                            it.getRef(1) as TimeUnit,
                            it.getInt(2).toLong()
                        )
                        else -> error("WorldBorder#setSize 函数参数数量错误: ${"args"}")
                    }
                }
                .function("setSize", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.setSize(it.getAsDouble(0))
                        2 -> it.target?.setSize(it.getAsDouble(0), it.getInt(1).toLong())
                        3 -> it.target?.setSize(
                            it.getAsDouble(0),
                            it.getRef(1) as TimeUnit,
                            it.getInt(2).toLong()
                        )
                        else -> error("WorldBorder#setSize 函数参数数量错误: ${"args"}")
                    }
                }
                .function("setSize", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.setSize(it.getAsDouble(0))
                        2 -> it.target?.setSize(it.getAsDouble(0), it.getInt(1).toLong())
                        3 -> it.target?.setSize(
                            it.getAsDouble(0),
                            it.getRef(1) as TimeUnit,
                            it.getInt(2).toLong()
                        )
                        else -> error("WorldBorder#setSize 函数参数数量错误: ${"args"}")
                    }
                }
                .function("center", returnsObject().noParams()) { it.target?.center }
                .function("setCenter", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.setCenter(it.getRef(0) as Location)
                    } else {
                        it.target?.setCenter(
                            it.getAsDouble(0),
                            it.getAsDouble(1)
                        )
                    }
                }
                .function("setCenter", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.setCenter(it.getRef(0) as Location)
                    } else {
                        it.target?.setCenter(
                            it.getAsDouble(0),
                            it.getAsDouble(1)
                        )
                    }
                }
                .function("damageBuffer", returnsObject().noParams()) { it.target?.damageBuffer }
                .function("setDamageBuffer", returnsObject().params(Type.OBJECT)) { it.target?.setDamageBuffer(it.getAsDouble(0)) }
                .function("damageAmount", returnsObject().noParams()) { it.target?.damageAmount }
                .function("setDamageAmount", returnsObject().params(Type.OBJECT)) { it.target?.setDamageAmount(it.getAsDouble(0)) }
                .function("warningTime", returnsObject().noParams()) { it.target?.warningTime }
                .function("setWarningTime", returnsObject().params(Type.OBJECT)) { it.target?.setWarningTime(it.getInt(0).toInt()) }
                .function("warningDistance", returnsObject().noParams()) { it.target?.warningDistance }
                .function("setWarningDistance", returnsObject().params(Type.OBJECT)) { it.target?.setWarningDistance(it.getInt(0).toInt()) }
                .function("isInside", returns(Type.Z).params(Type.OBJECT)) { it.target?.isInside(it.getRef(0) as Location) }
                .function("maxSize", returnsObject().noParams()) { it.target?.maxSize }
                .function("maxCenterCoordinate", returnsObject().noParams()) { it.target?.maxCenterCoordinate }
        }
    }
}

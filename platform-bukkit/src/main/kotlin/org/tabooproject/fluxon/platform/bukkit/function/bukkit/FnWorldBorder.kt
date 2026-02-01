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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.WorldBorder"])
@PlatformSide(Platform.BUKKIT)
object FnWorldBorder {

    val TYPE = Type.fromClass(WorldBorder::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WorldBorder::class.java)
                .function("world", returnsObject().noParams()) { it.setReturnRef(it.target?.world) }
                .function("reset", returnsVoid().noParams()) { it.target?.reset() }
                .function("size", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.size ?: 0.0) }
                .function("setSize", returnsVoid().params(Type.D)) {
                    it.target?.setSize(it.getDouble(0))
                }
                .function("setSize", returnsVoid().params(Type.D, Type.J)) {
                    it.target?.setSize(it.getDouble(0), it.getLong(1))
                }
                .function("setSize", returnsVoid().params(Type.D, Type.OBJECT, Type.J)) {
                    it.target?.setSize(
                        it.getDouble(0),
                        it.getRef(1) as TimeUnit,
                        it.getLong(2)
                    )
                }
                .function("center", returnsObject().noParams()) { it.setReturnRef(it.target?.center) }
                .function("setCenter", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setCenter(it.getRef(0) as Location)
                }
                .function("setCenter", returnsVoid().params(Type.D, Type.D)) {
                    it.target?.setCenter(
                        it.getDouble(0),
                        it.getDouble(1)
                    )
                }
                .function("damageBuffer", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.damageBuffer ?: 0.0) }
                .function("setDamageBuffer", returnsVoid().params(Type.D)) { it.target?.setDamageBuffer(it.getDouble(0)) }
                .function("damageAmount", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.damageAmount ?: 0.0) }
                .function("setDamageAmount", returnsVoid().params(Type.D)) { it.target?.setDamageAmount(it.getDouble(0)) }
                .function("warningTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.warningTime ?: 0) }
                .function("setWarningTime", returnsVoid().params(Type.I)) { it.target?.setWarningTime(it.getInt(0).toInt()) }
                .function("warningDistance", returns(Type.I).noParams()) { it.setReturnInt(it.target?.warningDistance ?: 0) }
                .function("setWarningDistance", returnsVoid().params(Type.I)) { it.target?.setWarningDistance(it.getInt(0).toInt()) }
                .function("isInside", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.isInside(it.getRef(0) as Location) ?: false)
                }
                .function("maxSize", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.maxSize ?: 0.0) }
                .function("maxCenterCoordinate", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.maxCenterCoordinate ?: 0.0) }
        }
    }
}

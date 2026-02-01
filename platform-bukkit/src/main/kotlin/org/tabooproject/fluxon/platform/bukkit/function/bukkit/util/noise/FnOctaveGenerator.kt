package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.OctaveGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.noise.OctaveGenerator"])
@PlatformSide(Platform.BUKKIT)
object FnOctaveGenerator {

    val TYPE = Type.fromClass(OctaveGenerator::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(OctaveGenerator::class.java)
                .function("setScale", returnsVoid().params(Type.D)) { it.target?.setScale(it.getDouble(0)) }
                .function("xScale", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.getXScale() ?: 0.0) }
                .function("setXScale", returnsVoid().params(Type.D)) { it.target?.setXScale(it.getDouble(0)) }
                .function("yScale", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.getYScale() ?: 0.0) }
                .function("setYScale", returnsVoid().params(Type.D)) { it.target?.setYScale(it.getDouble(0)) }
                .function("zScale", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.getZScale() ?: 0.0) }
                .function("setZScale", returnsVoid().params(Type.D)) { it.target?.setZScale(it.getDouble(0)) }
                .function("octaves", returnsObject().noParams()) { it.setReturnRef(it.target?.getOctaves()) }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D, Type.Z)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getBool(3)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D, Type.D, Type.Z)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3),
                        it.getBool(4)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D, Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3),
                        it.getDouble(4)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D, Type.D, Type.D, Type.Z)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3),
                        it.getDouble(4),
                        it.getBool(5)
                    ) ?: 0.0)
                }
        }
    }
}

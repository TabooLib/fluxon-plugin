package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Entity
import org.bukkit.entity.FishHook
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.entity.FishHook"])
@PlatformSide(Platform.BUKKIT)
object FnFishHook {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FishHook::class.java)
                .function("isUnhooked", returns(Type.Z).noParams()) { it.target?.state == FishHook.HookState.UNHOOKED }
                .function("isHookedEntity", returns(Type.Z).noParams()) { it.target?.state == FishHook.HookState.HOOKED_ENTITY }
                .function("isBobbing", returns(Type.Z).noParams()) { it.target?.state == FishHook.HookState.BOBBING }
                .function("setLureTime", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        val time = it.getInt(0).toInt()
                        it.target?.setLureTime(time, time)
                    } else {
                        it.target?.setLureTime(it.getInt(0).toInt(), it.getInt(1).toInt())
                    }
                }
                .function("setLureTime", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        val time = it.getInt(0).toInt()
                        it.target?.setLureTime(time, time)
                    } else {
                        it.target?.setLureTime(it.getInt(0).toInt(), it.getInt(1).toInt())
                    }
                }
                .function("setLureAngle", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        val time = it.getFloat(0)
                        it.target?.setLureAngle(time, time)
                    } else {
                        it.target?.setLureAngle(
                            it.getFloat(0),
                            it.getFloat(1)
                        )
                    }
                }
                .function("setLureAngle", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        val time = it.getFloat(0)
                        it.target?.setLureAngle(time, time)
                    } else {
                        it.target?.setLureAngle(
                            it.getFloat(0),
                            it.getFloat(1)
                        )
                    }
                }

                .function("minWaitTime", returnsObject().noParams()) { it.target?.minWaitTime }
                .function("setMinWaitTime", returnsObject().params(Type.OBJECT)) { it.target?.setMinWaitTime(it.getInt(0).toInt()) }
                .function("maxWaitTime", returnsObject().noParams()) { it.target?.maxWaitTime }
                .function("setMaxWaitTime", returnsObject().params(Type.OBJECT)) { it.target?.setMaxWaitTime(it.getInt(0).toInt()) }
                .function("setWaitTime", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.setWaitTime(it.getInt(0).toInt(), it.getInt(1).toInt()) }
                .function("minLureTime", returnsObject().noParams()) { it.target?.minLureTime }
                .function("setMinLureTime", returnsObject().params(Type.OBJECT)) { it.target?.setMinLureTime(it.getInt(0).toInt()) }
                .function("maxLureTime", returnsObject().noParams()) { it.target?.maxLureTime }
                .function("setMaxLureTime", returnsObject().params(Type.OBJECT)) { it.target?.setMaxLureTime(it.getInt(0).toInt()) }
                .function("minLureAngle", returnsObject().noParams()) { it.target?.minLureAngle }
                .function("setMinLureAngle", returnsObject().params(Type.OBJECT)) { it.target?.setMinLureAngle(it.getFloat(0)) }
                .function("maxLureAngle", returnsObject().noParams()) { it.target?.maxLureAngle }
                .function("setMaxLureAngle", returnsObject().params(Type.OBJECT)) { it.target?.setMaxLureAngle(it.getFloat(0)) }
                .function("applyLure", returnsObject().noParams()) { it.target?.applyLure }
                .function("setApplyLure", returnsObject().params(Type.OBJECT)) { it.target?.setApplyLure(it.getBool(0)) }
                .function("biteChance", returnsObject().noParams()) { it.target?.biteChance }
                .function("setBiteChance", returnsObject().params(Type.OBJECT)) { it.target?.setBiteChance(it.getAsDouble(0)) }
                .function("isInOpenWater", returns(Type.Z).noParams()) { it.target?.isInOpenWater }
                .function("hookedEntity", returnsObject().noParams()) { it.target?.hookedEntity }
                .function("setHookedEntity", returnsObject().params(Type.OBJECT)) { it.target?.setHookedEntity(it.getRef(0) as Entity) }
                .function("pullHookedEntity", returnsObject().noParams()) { it.target?.pullHookedEntity() }
                .function("isSkyInfluenced", returns(Type.Z).noParams()) { it.target?.isSkyInfluenced }
                .function("setSkyInfluenced", returnsObject().params(Type.OBJECT)) { it.target?.setSkyInfluenced(it.getBool(0)) }
                .function("isRainInfluenced", returns(Type.Z).noParams()) { it.target?.isRainInfluenced }
                .function("setRainInfluenced", returnsObject().params(Type.OBJECT)) { it.target?.setRainInfluenced(it.getBool(0)) }
                .function("state", returnsObject().noParams()) { it.target?.state }
//                .function("waitTime", returnsObject().noParams()) { it.target?.waitTime }
//                .function("setWaitTime", returnsObject().params(Type.OBJECT)) { it.target?.apply { waitTime = it.getInt(0).toInt() } }
        }
    }
}

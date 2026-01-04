package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Entity
import org.bukkit.entity.FishHook
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnFishHook {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FishHook::class.java)
                // 只读属性
                .function("isInOpenWater", 0) { it.target?.isInOpenWater }
                .function("hookedEntity", 0) { it.target?.hookedEntity }
                .function("isUnhooked", 0) { it.target?.state == FishHook.HookState.UNHOOKED }
                .function("isHookedEntity", 0) { it.target?.state == FishHook.HookState.HOOKED_ENTITY }
                .function("isBobbing", 0) { it.target?.state == FishHook.HookState.BOBBING }

                // 可读写属性
                .function("minWaitTime", 0) { it.target?.minWaitTime }
                .syncFunction("setMinWaitTime", 1) { it.target?.apply { minWaitTime = it.getNumber(0).toInt() } }
                .function("maxWaitTime", 0) { it.target?.maxWaitTime }
                .syncFunction("setMaxWaitTime", 1) { it.target?.apply { maxWaitTime = it.getNumber(0).toInt() } }
//                .function("waitTime", 0) { it.target?.waitTime }
//                .syncFunction("setWaitTime", 1) { it.target?.apply { waitTime = it.getNumber(0).toInt() } }

                .function("minLureTime", 0) { it.target?.minLureTime }
                .syncFunction("setMinLureTime", 1) { it.target?.apply { minLureTime = it.getNumber(0).toInt() } }
                .function("maxLureTime", 0) { it.target?.maxLureTime }
                .syncFunction("setMaxLureTime", 1) { it.target?.apply { maxLureTime = it.getNumber(0).toInt() } }
                .syncFunction("setLureTime", 1) {
                    it.target?.apply {
                        val time = it.getNumber(0).toInt()
                        setLureTime(time, time)
                    }
                }

                .function("minLureAngle", 0) { it.target?.minLureAngle }
                .syncFunction("setMinLureAngle", 1) { it.target?.apply { minLureAngle = it.getNumber(0).toFloat() } }
                .function("maxLureAngle", 0) { it.target?.maxLureAngle }
                .syncFunction("setMaxLureAngle", 1) { it.target?.apply { maxLureAngle = it.getNumber(0).toFloat() } }
                .syncFunction("setLureAngle", 1) {
                    it.target?.apply {
                        val angle = it.getNumber(0).toFloat()
                        setLureAngle(angle, angle)
                    }
                }

                .function("applyLure", 0) { it.target?.applyLure }
                .syncFunction("setApplyLure", 1) { it.target?.apply { applyLure = it.getBoolean(0) } }
                .syncFunction("setHookedEntity", 1) { it.target?.apply { hookedEntity = it.getArgument(0) as? Entity } }
                .function("isSkyInfluenced", 0) { it.target?.isSkyInfluenced }
                .syncFunction("setSkyInfluenced", 1) { it.target?.apply { isSkyInfluenced = it.getBoolean(0) } }
                .function("isRainInfluenced", 0) { it.target?.isRainInfluenced }
                .syncFunction("setRainInfluenced", 1) { it.target?.apply { isRainInfluenced = it.getBoolean(0) } }
        }
    }
}

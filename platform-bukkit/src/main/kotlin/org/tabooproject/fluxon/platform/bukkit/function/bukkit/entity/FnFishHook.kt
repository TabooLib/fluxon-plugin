package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Entity
import org.bukkit.entity.FishHook
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires


@Requires(classes = ["org.bukkit.entity.FishHook"])
@PlatformSide(Platform.BUKKIT)
object FnFishHook {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FishHook::class.java)
                .function("isUnhooked", 0) { it.target?.state == FishHook.HookState.UNHOOKED }
                .function("isHookedEntity", 0) { it.target?.state == FishHook.HookState.HOOKED_ENTITY }
                .function("isBobbing", 0) { it.target?.state == FishHook.HookState.BOBBING }
                .function("setLureTime", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        val time = it.getNumber(0).toInt()
                        it.target?.setLureTime(time, time)
                    } else {
                        it.target?.setLureTime(it.getNumber(0).toInt(), it.getNumber(1).toInt())
                    }
                }
                .function("setLureAngle", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        val time = it.getNumber(0).toFloat()
                        it.target?.setLureAngle(time, time)
                    } else {
                        it.target?.setLureAngle(
                            it.getNumber(0).toFloat(),
                            it.getNumber(1).toFloat()
                        )
                    }
                }

                .function("minWaitTime", 0) { it.target?.minWaitTime }
                .function("setMinWaitTime", 1) { it.target?.setMinWaitTime(it.getNumber(0).toInt()) }
                .function("maxWaitTime", 0) { it.target?.maxWaitTime }
                .function("setMaxWaitTime", 1) { it.target?.setMaxWaitTime(it.getNumber(0).toInt()) }
                .function("setWaitTime", 2) { it.target?.setWaitTime(it.getNumber(0).toInt(), it.getNumber(1).toInt()) }
                .function("minLureTime", 0) { it.target?.minLureTime }
                .function("setMinLureTime", 1) { it.target?.setMinLureTime(it.getNumber(0).toInt()) }
                .function("maxLureTime", 0) { it.target?.maxLureTime }
                .function("setMaxLureTime", 1) { it.target?.setMaxLureTime(it.getNumber(0).toInt()) }
                .function("minLureAngle", 0) { it.target?.minLureAngle }
                .function("setMinLureAngle", 1) { it.target?.setMinLureAngle(it.getNumber(0).toFloat()) }
                .function("maxLureAngle", 0) { it.target?.maxLureAngle }
                .function("setMaxLureAngle", 1) { it.target?.setMaxLureAngle(it.getNumber(0).toFloat()) }
                .function("applyLure", 0) { it.target?.applyLure }
                .function("setApplyLure", 1) { it.target?.setApplyLure(it.getBoolean(0)) }
                .function("biteChance", 0) { it.target?.biteChance }
                .function("setBiteChance", 1) { it.target?.setBiteChance(it.getNumber(0).toDouble()) }
                .function("isInOpenWater", 0) { it.target?.isInOpenWater }
                .function("hookedEntity", 0) { it.target?.hookedEntity }
                .function("setHookedEntity", 1) { it.target?.setHookedEntity(it.getArgument(0) as Entity) }
                .function("pullHookedEntity", 0) { it.target?.pullHookedEntity() }
                .function("isSkyInfluenced", 0) { it.target?.isSkyInfluenced }
                .function("setSkyInfluenced", 1) { it.target?.setSkyInfluenced(it.getBoolean(0)) }
                .function("isRainInfluenced", 0) { it.target?.isRainInfluenced }
                .function("setRainInfluenced", 1) { it.target?.setRainInfluenced(it.getBoolean(0)) }
                .function("state", 0) { it.target?.state }
//                .function("waitTime", 0) { it.target?.waitTime }
//                .function("setWaitTime", 1) { it.target?.apply { waitTime = it.getNumber(0).toInt() } }
        }
    }
}

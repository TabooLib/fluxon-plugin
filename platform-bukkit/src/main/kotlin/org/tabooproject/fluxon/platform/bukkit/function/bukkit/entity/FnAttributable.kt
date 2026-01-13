package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.attribute.Attributable
import org.bukkit.attribute.Attribute
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnAttributable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Attributable::class.java)
                // 护甲
                .function("armor", 0) { it.target?.getAttribute(Attribute.GENERIC_ARMOR)?.value }
                .function("baseArmor", 0) { it.target?.getAttribute(Attribute.GENERIC_ARMOR)?.baseValue }
                .syncFunction("setBaseArmor", 1) { it.target?.getAttribute(Attribute.GENERIC_ARMOR)?.apply { baseValue = it.getNumber(0).toDouble() } }

                // 护甲韧性
                .function("armorToughness", 0) { it.target?.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS)?.value }
                .function("baseArmorToughness", 0) { it.target?.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS)?.baseValue }
                .syncFunction("setBaseArmorToughness", 1) { it.target?.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS)?.apply { baseValue = it.getNumber(0).toDouble() } }

                // 攻击伤害
                .function("attackDamage", 0) { it.target?.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)?.value }
                .function("baseAttackDamage", 0) { it.target?.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)?.baseValue }
                .syncFunction("setBaseAttackDamage", 1) { it.target?.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)?.apply { baseValue = it.getNumber(0).toDouble() } }

                // 攻击击退
                .function("attackKnockback", 0) { it.target?.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK)?.value }
                .function("baseAttackKnockback", 0) { it.target?.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK)?.baseValue }
                .syncFunction("setBaseAttackKnockback", 1) { it.target?.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK)?.apply { baseValue = it.getNumber(0).toDouble() } }

                // 飞行速度
                .function("flyingSpeed", 0) { it.target?.getAttribute(Attribute.GENERIC_FLYING_SPEED)?.value }
                .function("baseFlyingSpeed", 0) { it.target?.getAttribute(Attribute.GENERIC_FLYING_SPEED)?.baseValue }
                .syncFunction("setBaseFlyingSpeed", 1) { it.target?.getAttribute(Attribute.GENERIC_FLYING_SPEED)?.apply { baseValue = it.getNumber(0).toDouble() } }

                // 跟随范围
                .function("followRange", 0) { it.target?.getAttribute(Attribute.GENERIC_FOLLOW_RANGE)?.value }
                .function("baseFollowRange", 0) { it.target?.getAttribute(Attribute.GENERIC_FOLLOW_RANGE)?.baseValue }
                .syncFunction("setBaseFollowRange", 1) { it.target?.getAttribute(Attribute.GENERIC_FOLLOW_RANGE)?.apply { baseValue = it.getNumber(0).toDouble() } }

                // 幸运
                .function("luck", 0) { it.target?.getAttribute(Attribute.GENERIC_LUCK)?.value }
                .function("baseLuck", 0) { it.target?.getAttribute(Attribute.GENERIC_LUCK)?.baseValue }
                .syncFunction("setBaseLuck", 1) { it.target?.getAttribute(Attribute.GENERIC_LUCK)?.apply { baseValue = it.getNumber(0).toDouble() } }

                // 最大生命值
                .function("maxHealth", 0) { it.target?.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.value }
                .function("baseMaxHealth", 0) { it.target?.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue }
                .syncFunction("setBaseMaxHealth", 1) { it.target?.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.apply { baseValue = it.getNumber(0).toDouble() } }

                // 移动速度
                .function("movementSpeed", 0) { it.target?.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)?.value }
                .function("baseMovementSpeed", 0) { it.target?.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)?.baseValue }
                .syncFunction("setBaseMovementSpeed", 1) { it.target?.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)?.apply { baseValue = it.getNumber(0).toDouble() } }
        }
    }
}

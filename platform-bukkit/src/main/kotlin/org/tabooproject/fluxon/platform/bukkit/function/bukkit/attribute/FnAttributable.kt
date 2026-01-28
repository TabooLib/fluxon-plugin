package org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute

import org.bukkit.attribute.Attributable
import org.bukkit.attribute.Attribute
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.attribute.Attributable"])
@PlatformSide(Platform.BUKKIT)
object FnAttributable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Attributable::class.java)
                // 护甲
                .function("armor", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ARMOR)?.value) }
                .function("baseArmor", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ARMOR)?.baseValue) }
                .syncFunction("setBaseArmor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ARMOR)?.apply { baseValue = it.getAsDouble(0) }) }

                // 护甲韧性
                .function("armorToughness", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS)?.value) }
                .function("baseArmorToughness", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS)?.baseValue) }
                .syncFunction("setBaseArmorToughness", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                // 攻击伤害
                .function("attackDamage", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)?.value) }
                .function("baseAttackDamage", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)?.baseValue) }
                .syncFunction("setBaseAttackDamage", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                // 攻击击退
                .function("attackKnockback", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK)?.value) }
                .function("baseAttackKnockback", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK)?.baseValue) }
                .syncFunction("setBaseAttackKnockback", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                // 飞行速度
                .function("flyingSpeed", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_FLYING_SPEED)?.value) }
                .function("baseFlyingSpeed", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_FLYING_SPEED)?.baseValue) }
                .syncFunction("setBaseFlyingSpeed", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_FLYING_SPEED)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                // 跟随范围
                .function("followRange", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_FOLLOW_RANGE)?.value) }
                .function("baseFollowRange", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_FOLLOW_RANGE)?.baseValue) }
                .syncFunction("setBaseFollowRange", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_FOLLOW_RANGE)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                // 幸运
                .function("luck", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_LUCK)?.value) }
                .function("baseLuck", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_LUCK)?.baseValue) }
                .syncFunction("setBaseLuck", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_LUCK)?.apply { baseValue = it.getAsDouble(0) }) }

                // 最大生命值
                .function("maxHealth", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.value) }
                .function("baseMaxHealth", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue) }
                .syncFunction("setBaseMaxHealth", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_MAX_HEALTH)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                // 移动速度
                .function("movementSpeed", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)?.value) }
                .function("baseMovementSpeed", returnsObject().noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)?.baseValue) }
                .syncFunction("setBaseMovementSpeed", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                .function("getAttribute", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getAttribute(it.getRef(0) as Attribute)) }
        }
    }
}

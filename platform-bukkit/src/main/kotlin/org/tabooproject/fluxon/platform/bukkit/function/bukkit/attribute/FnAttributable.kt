package org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute

import org.bukkit.attribute.Attributable
import org.bukkit.attribute.Attribute
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.attribute.Attributable"])
@PlatformSide(Platform.BUKKIT)
object FnAttributable {

    val TYPE = Type.fromClass(Attributable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Attributable::class.java)
                // 护甲
                .function("armor", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ARMOR)?.value) }
                .function("baseArmor", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ARMOR)?.baseValue) }
                .function("setBaseArmor",returns(FnAttributeInstance.TYPE).params(Type.D)) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ARMOR)?.apply { baseValue = it.getAsDouble(0) }) }

                // 护甲韧性
                .function("armorToughness", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS)?.value) }
                .function("baseArmorToughness", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS)?.baseValue) }
                .function("setBaseArmorToughness",returns(FnAttributeInstance.TYPE).params(Type.D)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                // 攻击伤害
                .function("attackDamage", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)?.value) }
                .function("baseAttackDamage", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)?.baseValue) }
                .function("setBaseAttackDamage",returns(FnAttributeInstance.TYPE).params(Type.D)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                // 攻击击退
                .function("attackKnockback", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK)?.value) }
                .function("baseAttackKnockback", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK)?.baseValue) }
                .function("setBaseAttackKnockback", returns(FnAttributeInstance.TYPE).params(Type.D)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                // 飞行速度
                .function("flyingSpeed", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_FLYING_SPEED)?.value) }
                .function("baseFlyingSpeed", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_FLYING_SPEED)?.baseValue) }
                .function("setBaseFlyingSpeed",returns(FnAttributeInstance.TYPE).params(Type.D)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_FLYING_SPEED)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                // 跟随范围
                .function("followRange", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_FOLLOW_RANGE)?.value) }
                .function("baseFollowRange", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_FOLLOW_RANGE)?.baseValue) }
                .function("setBaseFollowRange",returns(FnAttributeInstance.TYPE).params(Type.D)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_FOLLOW_RANGE)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                // 幸运
                .function("luck", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_LUCK)?.value) }
                .function("baseLuck", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_LUCK)?.baseValue) }
                .function("setBaseLuck",returns(FnAttributeInstance.TYPE).params(Type.D)) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_LUCK)?.apply { baseValue = it.getAsDouble(0) }) }

                // 最大生命值
                .function("maxHealth", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.value) }
                .function("baseMaxHealth", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.baseValue) }
                .function("setBaseMaxHealth",returns(FnAttributeInstance.TYPE).params(Type.D)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_MAX_HEALTH)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                // 移动速度
                .function("movementSpeed", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)?.value) }
                .function("baseMovementSpeed", returns(Type.D).noParams()) { it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)?.baseValue) }
                .function("setBaseMovementSpeed",returns(FnAttributeInstance.TYPE).params(Type.D)) {
                    it.setReturnRef(it.target?.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)
                        ?.apply { baseValue = it.getAsDouble(0) })
                }

                .function("getAttribute", returns(FnAttributeInstance.TYPE).params(FnAttribute.TYPE)) { it.setReturnRef(it.target?.getAttribute(it.getRef(0) as Attribute)) }
                .function("getAttribute", returns(FnAttributeInstance.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getAttribute(it.getRef(0) as Attribute)) }
        }
    }
}

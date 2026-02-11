package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Material
import org.bukkit.block.DecoratedPot
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnDecoratedPotInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.library.xseries.XMaterial
import kotlin.jvm.optionals.getOrNull

@Requires(classes = ["org.bukkit.block.DecoratedPot"])
@PlatformSide(Platform.BUKKIT)
object FnDecoratedPot {

    val TYPE = Type.fromClass(DecoratedPot::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DecoratedPot::class.java)
                .function("setSherd", returnsVoid().params(FnDecoratedPotSide.TYPE, FnMaterial.TYPE)) {
                    it.target?.setSherd(
                        it.getRef(0) as DecoratedPot.Side,
                        it.getRef(1) as Material
                    )
                }
                .function("setSherd", returnsVoid().params(FnDecoratedPotSide.TYPE, Type.STRING)) {
                    it.target?.setSherd(
                        it.getRef(0) as DecoratedPot.Side,
                        XMaterial.matchXMaterial(it.getString(1)).getOrNull()?.get()
                    )
                }
                .function("setSherd", returnsVoid().params(Type.STRING, FnMaterial.TYPE)) {
                    FnDecoratedPotSide.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.setSherd(
                            p0,
                            it.getRef(1) as Material
                        )
                    }
                }
                .function("setSherd", returnsVoid().params(Type.STRING, Type.STRING)) {
                    val side = FnDecoratedPotSide.enumValue(it.getString(0)) ?: return@function
                    val mat = XMaterial.matchXMaterial(it.getString(1)).getOrNull()?.get() ?: return@function
                    it.target?.setSherd(side, mat)
                }
                .function("getSherd", returns(FnMaterial.TYPE).params(FnDecoratedPotSide.TYPE)) { it.setReturnRef(it.target?.getSherd(it.getRef(0) as DecoratedPot.Side)) }
                .function("shards", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.shards) }
                .function("inventory", returns(FnDecoratedPotInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("snapshotInventory", returns(FnDecoratedPotInventory.TYPE).noParams()) { it.setReturnRef(it.target?.snapshotInventory) }
        }
    }
}

@Requires(classes = ["org.bukkit.block.DecoratedPot.Side"])
@PlatformSide(Platform.BUKKIT)
object FnDecoratedPotSide : FnEnumGetter<DecoratedPot.Side>() {

    override val enumClass: Class<DecoratedPot.Side> = DecoratedPot.Side::class.java
}
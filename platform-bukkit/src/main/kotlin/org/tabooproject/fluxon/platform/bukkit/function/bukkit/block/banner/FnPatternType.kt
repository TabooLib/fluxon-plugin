package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.banner

import org.bukkit.block.banner.PatternType
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import taboolib.library.xseries.XPatternType
import kotlin.jvm.optionals.getOrNull

@Requires(classes = ["org.bukkit.block.banner.PatternType"])
@PlatformSide(Platform.BUKKIT)
object FnPatternType : FnEnumGetter<PatternType>() {

    override val enumClass: Class<PatternType> = PatternType::class.java

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PatternType::class.java)
                .function("key", returns(FnNamespacedKey.TYPE).noParams()) { it.setReturnRef(it.target?.key) }
                .function("identifier", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.identifier) }
        }
    }

    override fun enumValue(value: String): PatternType? {
        return XPatternType.of(value).getOrNull()?.get()
    }
}

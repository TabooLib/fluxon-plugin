package org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement

import com.google.common.base.Enums
import org.bukkit.advancement.AdvancementDisplayType
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnChatColor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.advancement.AdvancementDisplayType"])
@PlatformSide(Platform.BUKKIT)
object FnAdvancementDisplayType {

    val TYPE = Type.fromClass(AdvancementDisplayType::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("advancementDisplayType", returns(FnAdvancementDisplay.TYPE).params(Type.STRING)) {
                it.setReturnRef(Enums.getIfPresent(AdvancementDisplayType::class.java, it.getString(0)).orNull())
            }
            registerExtension(AdvancementDisplayType::class.java)
                .function("color", returns(FnChatColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
        }
    }
}

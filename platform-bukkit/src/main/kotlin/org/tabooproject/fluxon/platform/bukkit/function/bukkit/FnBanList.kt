package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.BanList
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.time.Duration
import java.time.Instant
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.BanList"])
@PlatformSide(Platform.BUKKIT)
object FnBanList {

    val TYPE = Type.fromClass(BanList::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BanList::class.java)
                .function("getBanEntry",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBanEntry.TYPE).params(Type.STRING)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is String -> it.target?.getBanEntry(var1)
                        else -> (it.target as? BanList<Any>)?.getBanEntry(var1!!)
                    })
                }
                .function("addBan",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBanEntry.TYPE).params(Type.STRING, Type.STRING, org.tabooproject.fluxon.util.StandardTypes.DATE, Type.STRING)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is String -> it.target?.addBan(
                            var1,
                            it.getString(1),
                            it.getRef(2) as? Date,
                            it.getString(3)
                        )

                        else -> when (val var3 = it.getRef(2)) {
                            is Date -> (it.target as? BanList<Any>)?.addBan(
                                var1!!,
                                it.getString(1),
                                var3,
                                it.getString(3)
                            )

                            is Instant -> (it.target as? BanList<Any>)?.addBan(
                                var1!!,
                                it.getString(1),
                                var3,
                                it.getString(3)
                            )

                            is Duration -> (it.target as? BanList<Any>)?.addBan(
                                var1!!,
                                it.getString(1),
                                var3,
                                it.getString(3)
                            )

                            else -> throw IllegalArgumentException("参数 3 必须是 Date, Instant, 或 Duration 类型")
                        }
                    })
                }
                .function("banEntries",returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.banEntries) }
                .function("entries",returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.getEntries()) }
                .function("isBanned",returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is String -> it.target?.isBanned(var1)
                        else -> (it.target as? BanList<Any>)?.isBanned(var1!!)
                    } ?: false)
                }
                .function("pardon",returnsVoid().params(Type.STRING)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.pardon(var1)
                        else -> (it.target as? BanList<Any>)?.pardon(var1!!)
                    }
                }
        }
    }
}

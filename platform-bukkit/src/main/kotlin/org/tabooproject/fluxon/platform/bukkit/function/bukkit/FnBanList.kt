package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.BanList
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.time.Duration
import java.time.Instant
import java.util.*

object FnBanList {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BanList::class.java)
                .function("banEntry", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.getBanEntry(var1)
                        else -> (it.target as? BanList<Any>)?.getBanEntry(var1!!)
                    }
                }
                .function("addBan", 4) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.addBan(
                            var1,
                            it.getString(1),
                            it.getArgument(2) as? Date,
                            it.getString(3)
                        )

                        else -> when (val var3 = it.getArgument(2)) {
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

                            else -> throw IllegalArgumentException("参数3必须是 Date, Instant, 或 Duration 类型")
                        }
                    }
                }
                .function("banEntries", 0) { it.target?.banEntries }
                .function("entries", 0) { it.target?.getEntries() }
                .function("isBanned", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.isBanned(var1)
                        else -> (it.target as? BanList<Any>)?.isBanned(var1!!)
                    }
                }
                .function("pardon", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.pardon(var1)
                        else -> (it.target as? BanList<Any>)?.pardon(var1!!)
                    }
                }
        }
    }
}

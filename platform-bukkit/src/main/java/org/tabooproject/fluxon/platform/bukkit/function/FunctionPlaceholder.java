package org.tabooproject.fluxon.platform.bukkit.function;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.tabooproject.fluxon.runtime.Environment;
import org.tabooproject.fluxon.runtime.FluxonRuntime;
import org.tabooproject.fluxon.runtime.NativeFunction;
import taboolib.common.LifeCycle;
import taboolib.common.platform.Awake;

import java.util.Arrays;

/**
 * Fluxon
 * org.tabooproject.fluxon.extension.bukkit.function.game.compat.FunctionScoreboard
 *
 * @author mical
 * @since 2025/7/21 18:18
 */
public class FunctionPlaceholder {

    @Awake(LifeCycle.LOAD)
    public static void init() {
        final FluxonRuntime runtime = FluxonRuntime.getInstance();
        final NativeFunction.NativeCallable<?> function = context -> {
            final Environment env = context.getEnvironment();
            final Object[] args = context.getArguments();
            final Player player;
            final String content = args[0].toString();
            if (context.getArguments().length > 1) {
                player = (Player) args[1];
            } else {
                Object find = env.getRootVariables().get("player");
                if (find instanceof Player) {
                    player = (Player) find;
                } else {
                    throw new IllegalStateException("No player found in environment");
                }
            }
            return PlaceholderAPI.setPlaceholders(player, content);
        };
        runtime.registerFunction("papi", Arrays.asList(1, 2), function);
        runtime.registerFunction("placeholder", Arrays.asList(1, 2), function);
    }
}
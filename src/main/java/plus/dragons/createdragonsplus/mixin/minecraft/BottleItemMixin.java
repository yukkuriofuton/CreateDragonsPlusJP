/*
 * Copyright (C) 2025  DragonsPlus
 * SPDX-License-Identifier: LGPL-3.0-or-later
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package plus.dragons.createdragonsplus.mixin.minecraft;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.item.BottleItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BottleItem.class)
public class BottleItemMixin {
    @WrapOperation(method = "lambda$use$0", at = @At(value = "CONSTANT", args = "classValue=net/minecraft/world/entity/boss/enderdragon/EnderDragon"))
    private static boolean use$checkDragonBreathFluid(Object object, Operation<Boolean> original, AreaEffectCloud aoe) {
        if (aoe.getPersistentData().getBoolean("DragonBreath"))
            return true;
        return original.call(object);
    }
}

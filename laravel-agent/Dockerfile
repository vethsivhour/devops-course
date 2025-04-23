FROM jenkins/ssh-agent:latest
# install dependencies for laravel
# Switch to root to install packages
USER root
RUN apt-get update && apt-get install -y php8.2 php-xml php-mbstring php-curl npm curl unzip git && apt-get clean # Combine RUN commands and add curl, unzip, git

# Install Composer
RUN curl -sS https://getcomposer.org/installer -o composer-setup.php
# Verify Composer installer checksum (replace with the latest hash from getcomposer.org/download/)
# RUN php -r "if (hash_file('sha384', 'composer-setup.php') === 'dac665fdc30fdd8ec78b38b9800061b4150413ff2e3b6f88543c636f7cd84f6db9189d43a81e5503cda447da73c7e5b6') { echo 'Installer verified'.PHP_EOL; } else { echo 'Installer corrupt'.PHP_EOL; unlink('composer-setup.php'); exit(1); }"
RUN php composer-setup.php --install-dir=/usr/local/bin --filename=composer
RUN php -r "unlink('composer-setup.php');"

# Install common PHP extensions often needed by Laravel
RUN apt-get update && apt-get install -y php8.2-fileinfo php8.2-zip php8.2-dom php8.2-bcmath && apt-get clean # Specify PHP version for extensions

# Switch back to default user # <-- Remove this comment
# USER jenkins # <-- Remove this line
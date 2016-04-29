/*
    Gruntfile for project
    GS uses grunt, gulp would be prefered but until they change, we'll use grunt.

    Registered Tasks:
        js: Runs jshint and jscs on all Js files in ./app/...
        default (grunt): Runs all development tasks

    Tasks ToDo:
        build: will build the project into a dist folder, minifying JS, HTML and CSS and
                running angular template cache
*/
module.exports = function (grunt) {

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        jshint: {
            files: ['Gruntfile.js', '<%= pkg.devfolders.app %>/**/*.js'],
            options: {
                globals: {
                    angular: true,
                    expect: true,
                    descripe: true,
                    it: true,
                    console: true,
                    module: true
                }
            }
        },
        jscs: {
            main: '<%= pkg.devfolders.app %>/app.js',
            controllers: {
                src: ['Gruntfile.js', '<%= pkg.devfolders.app %>/**/*.js'],
                options: {
                    config: '.jscsrc'
                }
            }
        },
        sass: {
            options: {
                sourceMap: true
            },
            dist: {
                files: {
                    '<%= pkg.devfolders.css %>/main.css': '<%= pkg.devfolders.css %>/main.scss'
                }
            }
        },
        'http-server': {
            dev: {
                root: '',
                port: 8000,
                runInBackground: true,
                openBrowser: true
            }
        },
        karma: {
            unit: {
                configFile: 'karma.conf.js',
                background: false,
                singleRun: true
            }
        },
        processhtml: {
            options: {},
            dist: {
                files: {
                    'dist/index.html': ['index.html']
                }
            }
        },
        uglify: {
            options: {
                compress: {
                    drop_console: true
                }
            },
            my_target: {
                files: {
                    'dist/app/app.min.js': ['node_modules/angular/angular.min.js',
                                            'node_modules/angular-ui-router/release/angular-ui-router.min.js',
                                            'node_modules/angular-ui-grid/ui-grid.min.js',
                                            'app.js',
                                            'app/**/*.js',
                                            '!app/**/*.spec.js',
                                            'dist/app/templates.js']
                }
            }
        },
        cssmin: {
            target: {
                files: {
                    'dist/assets/css/main.min.css': ['node_modules/bootstrap/dist/css/bootstrap.min.css',
                                                     '<%= pkg.devfolders.css %>/main.css']
                }
            }
        },
        ngtemplates: {
            app: {
                src: 'app/views/**/*.html',
                dest: 'dist/app/templates.js',
                options: {
                    prefix: '/',
                    htmlmin: {
                        collapseBooleanAttributes:      true,
                        collapseWhitespace:             true,
                        removeAttributeQuotes:          true,
                        removeComments:                 true,
                        removeEmptyAttributes:          true,
                        removeRedundantAttributes:      true,
                        removeScriptTypeAttributes:     true,
                        removeStyleLinkTypeAttributes:  true,
                        keepClosingSlash:               true
                    }
                }
            }
        },
        watch: {
            js: {
                files: ['<%= jshint.files %>', 'app.js'],
                tasks: ['jshint'],
                options: {
                    livereload: true,
                }
            },
            css: {
                files: ['<%= pkg.devfolders.css %>/**/*.scss'],
                tasks: ['sass'],
                options: {
                    livereload: true,
                }
            },
            html: {
                files: ['<%= pkg.devfolders.app %>/**/*.html'],
                tasks: [],
                options: {
                    livereload: true
                }
            }
        }
    });

    /* Load grunt NPM modules */
    require('load-grunt-tasks')(grunt);

    var jsTasks = ['jshint', 'jscs', 'karma'];
    var sharedTasks = ['jshint', 'jscs', 'karma', 'sass'];
    var buildTasks = sharedTasks.concat([
        'processhtml',
        'cssmin',
        'ngtemplates',
        'uglify'
    ]);

    var devTasks = sharedTasks.concat([
        'http-server',
        'watch'
    ]);

    grunt.registerTask('js',   jsTasks);
    grunt.registerTask('test', jsTasks);
    grunt.registerTask('default', devTasks);
    grunt.registerTask('build', buildTasks);

};